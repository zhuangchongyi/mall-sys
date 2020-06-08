package com.ruoyi.project.mall.service;

import com.ruoyi.project.mall.domain.MallOrderAddress;

import java.util.List;

/**
 * 订单收货地址Service接口
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public interface IMallOrderAddressService 
{
    /**
     * 查询订单收货地址
     * 
     * @param orderAddressId 订单收货地址ID
     * @return 订单收货地址
     */
    public MallOrderAddress selectMallOrderAddressById(Long orderAddressId);

    /**
     * 查询订单收货地址列表
     * 
     * @param mallOrderAddress 订单收货地址
     * @return 订单收货地址集合
     */
    public List<MallOrderAddress> selectMallOrderAddressList(MallOrderAddress mallOrderAddress);

    /**
     * 新增订单收货地址
     * 
     * @param mallOrderAddress 订单收货地址
     * @return 结果
     */
    public int insertMallOrderAddress(MallOrderAddress mallOrderAddress);

    /**
     * 修改订单收货地址
     * 
     * @param mallOrderAddress 订单收货地址
     * @return 结果
     */
    public int updateMallOrderAddress(MallOrderAddress mallOrderAddress);

    /**
     * 批量删除订单收货地址
     * 
     * @param orderAddressIds 需要删除的订单收货地址ID
     * @return 结果
     */
    public int deleteMallOrderAddressByIds(Long[] orderAddressIds);

    /**
     * 删除订单收货地址信息
     * 
     * @param orderAddressId 订单收货地址ID
     * @return 结果
     */
    public int deleteMallOrderAddressById(Long orderAddressId);

    /**
     * 根据订单号查询订单地址
     * @param orderNum
     * @return
     */
    MallOrderAddress findOrderAddressByOrderNum(String orderNum);
}
