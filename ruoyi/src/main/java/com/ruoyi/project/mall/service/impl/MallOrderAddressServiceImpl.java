package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.mall.domain.MallOrderAddress;
import com.ruoyi.project.mall.mapper.MallOrderAddressMapper;
import com.ruoyi.project.mall.service.IMallOrderAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单收货地址Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
@Service
public class MallOrderAddressServiceImpl implements IMallOrderAddressService 
{
    @Autowired
    private MallOrderAddressMapper mallOrderAddressMapper;

    /**
     * 查询订单收货地址
     * 
     * @param orderAddressId 订单收货地址ID
     * @return 订单收货地址
     */
    @Override
    public MallOrderAddress selectMallOrderAddressById(Long orderAddressId)
    {
        return mallOrderAddressMapper.selectMallOrderAddressById(orderAddressId);
    }

    /**
     * 查询订单收货地址列表
     * 
     * @param mallOrderAddress 订单收货地址
     * @return 订单收货地址
     */
    @Override
    public List<MallOrderAddress> selectMallOrderAddressList(MallOrderAddress mallOrderAddress)
    {
        return mallOrderAddressMapper.selectMallOrderAddressList(mallOrderAddress);
    }

    /**
     * 新增订单收货地址
     * 
     * @param mallOrderAddress 订单收货地址
     * @return 结果
     */
    @Override
    public int insertMallOrderAddress(MallOrderAddress mallOrderAddress)
    {
        mallOrderAddress.setCreateTime(DateUtils.getNowDate());
        return mallOrderAddressMapper.insertMallOrderAddress(mallOrderAddress);
    }

    /**
     * 修改订单收货地址
     * 
     * @param mallOrderAddress 订单收货地址
     * @return 结果
     */
    @Override
    public int updateMallOrderAddress(MallOrderAddress mallOrderAddress)
    {
        return mallOrderAddressMapper.updateMallOrderAddress(mallOrderAddress);
    }

    /**
     * 批量删除订单收货地址
     * 
     * @param orderAddressIds 需要删除的订单收货地址ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderAddressByIds(Long[] orderAddressIds)
    {
        return mallOrderAddressMapper.deleteMallOrderAddressByIds(orderAddressIds);
    }

    /**
     * 删除订单收货地址信息
     * 
     * @param orderAddressId 订单收货地址ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderAddressById(Long orderAddressId)
    {
        return mallOrderAddressMapper.deleteMallOrderAddressById(orderAddressId);
    }

    /**
     * 根据订单号查询订单地址
     * @param orderNum
     * @return
     */
    @Override
    public MallOrderAddress findOrderAddressByOrderNum(String orderNum) {
        return mallOrderAddressMapper.findUserOrderAddressByOrderNum(orderNum);
    }
}
