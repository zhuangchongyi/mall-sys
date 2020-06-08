package com.ruoyi.project.mall.service;

import com.ruoyi.project.mall.domain.MallUserAddress;

import java.util.List;

/**
 * 用户地址Service接口
 * 
 * @author zhuangcy
 * @date 2020-06-03
 */
public interface IMallUserAddressService 
{
    /**
     * 查询用户地址
     * 
     * @param addressId 用户地址ID
     * @return 用户地址
     */
    public MallUserAddress selectMallUserAddressById(Long addressId);

    /**
     * 查询用户地址列表
     * 
     * @param mallUserAddress 用户地址
     * @return 用户地址集合
     */
    public List<MallUserAddress> selectMallUserAddressList(MallUserAddress mallUserAddress);

    /**
     * 新增用户地址
     * 
     * @param mallUserAddress 用户地址
     * @return 结果
     */
    public int insertMallUserAddress(MallUserAddress mallUserAddress);

    /**
     * 修改用户地址
     * 
     * @param mallUserAddress 用户地址
     * @return 结果
     */
    public int updateMallUserAddress(MallUserAddress mallUserAddress);

    /**
     * 批量删除用户地址
     * 
     * @param addressIds 需要删除的用户地址ID
     * @return 结果
     */
    public int deleteMallUserAddressByIds(Long[] addressIds);

    /**
     * 删除用户地址信息
     * 
     * @param addressId 用户地址ID
     * @return 结果
     */
    public int deleteMallUserAddressById(Long addressId);

    /**
     * 根据用户id查询用户地址列表
     * @param userId
     * @return
     */
    List<MallUserAddress> findUserAddressListByUserId(Long userId);

    /**
     * 修改用户地址默认状态
     * @param userId
     * @param addressId
     * @return
     */
    int updateUserAddressStatus(Long userId, Long addressId);
}
