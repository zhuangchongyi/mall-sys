package com.ruoyi.project.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.constant.OrderConstants;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.*;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.project.mall.domain.*;
import com.ruoyi.project.mall.mapper.MallOrderMapper;
import com.ruoyi.project.mall.service.IMallOrderAddressService;
import com.ruoyi.project.mall.service.IMallOrderDetailService;
import com.ruoyi.project.mall.service.IMallOrderService;
import com.ruoyi.project.mall.service.IMallOrderWxService;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 商品订单Service业务层处理
 *
 * @author zhuangcy
 * @date 2020-05-25
 */
@Service
public class MallOrderServiceImpl implements IMallOrderService {
    @Autowired
    private MallOrderMapper mallOrderMapper;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private IMallOrderAddressService orderAddressService;
    @Autowired
    private IMallOrderWxService wxOrderService;
    @Autowired
    private IMallOrderDetailService orderDetailService;

    /**
     * 添加用户订单
     *
     * @param formMap
     * @return
     */
    @Transactional
    @Override
    public Map<String, Object> saveUserOrder(Map<String, Object> formMap) {
        if (null == formMap
                || formMap.get("data") == null
                || formMap.get("address") == null
                || formMap.get("wantPrice") == null) {
            throw new CustomException("参数错误", HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> resMap = null;
        Date date = new Date(); // 订单时间
        String time = DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMMSS, date); // 订单时间串
        BigDecimal wantPrice = BigDecimalUtils.bigDecimal(ObjectUtils.toString(formMap.get("wantPrice")), 2);// 订单待付总金额

        List<Map<String, Object>> list = JSON.parseObject(ObjectUtils.toString(formMap.get("data")), ArrayList.class);
        if (null != list && !list.isEmpty()) {
            // 微信支付单号
            String wxOrderNum = OrderCodeUtils.getWxOrderCode(OrderConstants.ORDER_TYPE_WX, time, redisCache.getIncrementNum(Constants.WX_ORDER_SERIAL_NUMBER));
            for (Map<String, Object> map : list) {
                // 店铺信息
                MallStore mallStore = JSON.parseObject(JSON.toJSONString(map), MallStore.class);
                // 订单编号
                String orderNum = OrderCodeUtils.getOrderCode(OrderConstants.ORDER_TYPE_WX, time, redisCache.getIncrementNum(Constants.ORDER_SERIAL_NUMBER));
                // 订单收货地址
                MallOrderAddress orderUserAddress = JSON.parseObject(ObjectUtils.toString(formMap.get("address")), MallOrderAddress.class);


                // 保存订单地址
                orderUserAddress.setStoreId(mallStore.getStoreId());
                orderUserAddress.setOrderNum(orderNum);
                orderUserAddress.setCreateTime(date);
                orderAddressService.insertMallOrderAddress(orderUserAddress);
                // 保存微信订单
                MallOrderWx wxOrder = new MallOrderWx();
                wxOrder.setWxOrderNum(wxOrderNum);
                wxOrder.setOrderNum(orderNum);
                wxOrder.setWantPrice(wantPrice);
                wxOrder.setUserId(orderUserAddress.getUserId());
                wxOrder.setFreight(mallStore.getFreight());
                wxOrder.setTotalPrice(mallStore.getTotalPrice());
                wxOrder.setStoreId(mallStore.getStoreId());
                wxOrder.setCreateTime(date);
                wxOrderService.insertMallOrderWx(wxOrder);
                // 保存商品订单
                MallOrder order = new MallOrder();
                BeanUtils.copyProperties(wxOrder, order);
                order.setStoreName(mallStore.getStoreName());
                order.setRemark(mallStore.getRemark());
                order.setStoreUrl(mallStore.getStoreUrl());
                order.setOrderAddressId(orderUserAddress.getOrderAddressId());
                order.setCreateTime(date);
                mallOrderMapper.insertMallOrder(order);
                // 保存商品列表
//                List<MallOrderDetail> goodsList = JSON.toJavaObject(ObjectUtils.toString(map.get("goodsList")), ArrayList.class);
                List<MallOrderDetail> goodsList = JSON.parseArray(ObjectUtils.toString(map.get("goodsList")), MallOrderDetail.class);
                if (null != goodsList && !goodsList.isEmpty()) {
                    for (MallOrderDetail orderDetail : goodsList) {
                        // 保存商品订单明细
                        orderDetail.setOrderNum(orderNum);
                        orderDetail.setUserId(orderUserAddress.getUserId());
                        orderDetail.setStoreId(mallStore.getStoreId());
                        orderDetail.setOrderTime(date);
                        order.setCreateTime(new Date());
                        orderDetailService.insertMallOrderDetail(orderDetail);
                    }
                } else {
                    throw new CustomException("商品参数错误", HttpStatus.BAD_REQUEST);
                }
            }

            // 返回微信支付参数
            resMap = new HashMap<>();
            resMap.put("timeStamp", date.getTime());
            resMap.put("signType", "MD5");
            resMap.put("nonceStr", VerifyCodeUtils.generateVerifyCode(16));
            resMap.put("package", "");
            resMap.put("paySign", "");

            return resMap;
        } else {
            throw new CustomException("参数错误", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 查询用户订单
     *
     * @param userId
     * @param status
     * @return
     */
    @Override
    public List<MallOrder> findUserOrderByUserId(Long userId, String status) {
        if ("0".equals(status)) status = "";
        return mallOrderMapper.findUserOrderByUserId(userId, status);
    }

    /**
     * 修改订单状态
     *
     * @param mallOrder
     * @return
     */
    @Transactional
    @Override
    public int updateOrderStatus(MallOrder mallOrder) {
        if (mallOrder.getOrderId() == null || StringUtils.isEmpty(mallOrder.getStatus()))
            throw new CustomException("参数错误", HttpStatus.BAD_REQUEST);
        if (verifyOrderStatus(mallOrder)) {
            return mallOrderMapper.updateMallOrder(mallOrder);
        } else {
            return 0;
        }
    }

    /**
     * 校验订单状态
     *
     * @param mallOrder
     * @return
     */
    private boolean verifyOrderStatus(MallOrder mallOrder) {
        String checkStatus = mallOrder.getStatus(); // 修改状态
        MallOrder order = mallOrderMapper.selectMallOrderById(mallOrder.getOrderId());
        String status = order.getStatus(); // 当前状态
        if (checkStatus.equals(status)) {
            throw new CustomException("重复操作", HttpStatus.NOT_MODIFIED);
        } else if (OrderConstants.ORDER_STATUS_CANCEL.equals(status)) { // 取消的订单不允许操作
            throw new CustomException("订单已取消", HttpStatus.NOT_MODIFIED);
        }
        // 取消订单
        if (OrderConstants.ORDER_STATUS_CANCEL.equals(checkStatus)// 取消状态
                && OrderConstants.ORDER_STATUS_PAY.equals(status) // 未支付
                && OrderConstants.ORDER_STATUS_REMIND_STORE.equals(status)) { // 未发货
            mallOrder.setUpdateTime(new Date());
            return true;
        }
        // 订单支付
        if (OrderConstants.ORDER_STATUS_REMIND_STORE.equals(checkStatus) // 待发货状态
                && OrderConstants.ORDER_STATUS_PAY.equals(status)) { // 已支付状态
            mallOrder.setPayTime(new Date());
            return true;
        }
        // 订单发货
        if (OrderConstants.ORDER_STATUS_RECEIVING.equals(checkStatus) // 发货状态
                && OrderConstants.ORDER_STATUS_REMIND_STORE.equals(status)) { // 已支付状态
            mallOrder.setDeliveryTime(new Date());
            return true;
        }
        // 订单收货
        if (OrderConstants.ORDER_STATUS_EVALUATE.equals(checkStatus) // 收货状态
                && OrderConstants.ORDER_STATUS_RECEIVING.equals(status)) { // 已发货状态
            mallOrder.setReceivingTime(new Date());
            return true;
        }
        // 订单评价
        if (OrderConstants.ORDER_STATUS_EVALUATE_OVER.equals(checkStatus) // 已评价
                && OrderConstants.ORDER_STATUS_EVALUATE.equals(status)) { // 已收货
            return true;
        }


        return false;
    }

    /**
     * 查询商品订单
     *
     * @param orderId 商品订单ID
     * @return 商品订单
     */
    @Override
    public MallOrder selectMallOrderById(Long orderId) {
        return mallOrderMapper.selectMallOrderById(orderId);
    }

    /**
     * 查询商品订单列表
     *
     * @param mallOrder 商品订单
     * @return 商品订单
     */
    @Override
    public List<MallOrder> selectMallOrderList(MallOrder mallOrder) {
        return mallOrderMapper.selectMallOrderList(mallOrder);
    }

    /**
     * 新增商品订单
     *
     * @param mallOrder 商品订单
     * @return 结果
     */
    @Override
    public int insertMallOrder(MallOrder mallOrder) {
        mallOrder.setCreateTime(DateUtils.getNowDate());
        return mallOrderMapper.insertMallOrder(mallOrder);
    }

    /**
     * 修改商品订单
     *
     * @param mallOrder 商品订单
     * @return 结果
     */
    @Override
    public int updateMallOrder(MallOrder mallOrder) {
        return mallOrderMapper.updateMallOrder(mallOrder);
    }

    /**
     * 批量删除商品订单
     *
     * @param orderIds 需要删除的商品订单ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderByIds(Long[] orderIds) {
        return mallOrderMapper.deleteMallOrderByIds(orderIds);
    }

    /**
     * 删除商品订单信息
     *
     * @param orderId 商品订单ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderById(Long orderId) {
        return mallOrderMapper.deleteMallOrderById(orderId);
    }

}
