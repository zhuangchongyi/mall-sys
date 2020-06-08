package com.ruoyi.project.mall.service;

import com.ruoyi.project.mall.domain.MallOrder;

import java.util.List;
import java.util.Map;

/**
 * 商品订单Service接口
 * 
 * @author zhuangcy
 * @date 2020-05-25
 */
public interface IMallOrderService 
{
    /**
     * 查询商品订单
     * 
     * @param orderId 商品订单ID
     * @return 商品订单
     */
    public MallOrder selectMallOrderById(Long orderId);

    /**
     * 查询商品订单列表
     * 
     * @param mallOrder 商品订单
     * @return 商品订单集合
     */
    public List<MallOrder> selectMallOrderList(MallOrder mallOrder);

    /**
     * 新增商品订单
     * 
     * @param mallOrder 商品订单
     * @return 结果
     */
    public int insertMallOrder(MallOrder mallOrder);

    /**
     * 修改商品订单
     * 
     * @param mallOrder 商品订单
     * @return 结果
     */
    public int updateMallOrder(MallOrder mallOrder);

    /**
     * 批量删除商品订单
     * 
     * @param orderIds 需要删除的商品订单ID
     * @return 结果
     */
    public int deleteMallOrderByIds(Long[] orderIds);

    /**
     * 删除商品订单信息
     * 
     * @param orderId 商品订单ID
     * @return 结果
     */
    public int deleteMallOrderById(Long orderId);

    /**
     * 添加用户订单
     * @param formMap
     * @return
     */
    Map<String, Object> saveUserOrder(Map<String, Object> formMap);

    /**
     * 查询用户订单
     * @param userId
     * @param status
     * @return
     */
    List<MallOrder> findUserOrderByUserId(Long userId, String status);

    /**
     * 修改订单状态
     * @param mallOrder
     * @return
     */
    int updateOrderStatus(MallOrder mallOrder);
}
