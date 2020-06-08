package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.mall.domain.MallUserAddress;
import com.ruoyi.project.mall.mapper.MallUserAddressMapper;
import com.ruoyi.project.mall.service.IMallUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户地址Service业务层处理
 *
 * @author zhuangcy
 * @date 2020-06-03
 */
@Service
public class MallUserAddressServiceImpl implements IMallUserAddressService {
    @Autowired
    private MallUserAddressMapper mallUserAddressMapper;

    /**
     * 查询用户地址
     *
     * @param addressId 用户地址ID
     * @return 用户地址
     */
    @Override
    public MallUserAddress selectMallUserAddressById(Long addressId) {
        return mallUserAddressMapper.selectMallUserAddressById(addressId);
    }

    /**
     * 查询用户地址列表
     *
     * @param mallUserAddress 用户地址
     * @return 用户地址
     */
    @Override
    public List<MallUserAddress> selectMallUserAddressList(MallUserAddress mallUserAddress) {
        return mallUserAddressMapper.selectMallUserAddressList(mallUserAddress);
    }

    /**
     * 新增用户地址
     *
     * @param mallUserAddress 用户地址
     * @return 结果
     */
    @Override
    public int insertMallUserAddress(MallUserAddress mallUserAddress) {
        mallUserAddress.setCreateTime(DateUtils.getNowDate());
        mallUserAddress.setAddr(mallUserAddress.getProvince() +
                mallUserAddress.getCity() +
                mallUserAddress.getDistrict() +
                mallUserAddress.getDetail());
        // 如果用户添加地址为默认地址,则修改其他地址为0
        if (StringUtils.isNotEmpty(mallUserAddress.getStatus()) && Constants.ADDRESS_STATUS_DEF.equals(mallUserAddress.getStatus()))
            mallUserAddressMapper.updateUserAddressStatusById(mallUserAddress.getUserId(),null,Constants.ADDRESS_STATUS);
        return mallUserAddressMapper.insertMallUserAddress(mallUserAddress);
    }

    /**
     * 修改用户地址
     *
     * @param mallUserAddress 用户地址
     * @return 结果
     */
    @Override
    public int updateMallUserAddress(MallUserAddress mallUserAddress) {
        mallUserAddress.setAddr(mallUserAddress.getProvince() + Constants.SPACE +
                mallUserAddress.getCity() + Constants.SPACE +
                mallUserAddress.getDistrict() + Constants.SPACE +
                mallUserAddress.getDetail());
        // 如果用户修改地址为默认地址,则修改其他地址为0
        if (StringUtils.isNotEmpty(mallUserAddress.getStatus()) && Constants.ADDRESS_STATUS_DEF.equals(mallUserAddress.getStatus()))
            mallUserAddressMapper.updateUserAddressStatusById(mallUserAddress.getUserId(),null,Constants.ADDRESS_STATUS);
        return mallUserAddressMapper.updateMallUserAddress(mallUserAddress);
    }

    /**
     * 批量删除用户地址
     *
     * @param addressIds 需要删除的用户地址ID
     * @return 结果
     */
    @Override
    public int deleteMallUserAddressByIds(Long[] addressIds) {
        return mallUserAddressMapper.deleteMallUserAddressByIds(addressIds);
    }

    /**
     * 删除用户地址信息
     *
     * @param addressId 用户地址ID
     * @return 结果
     */
    @Override
    public int deleteMallUserAddressById(Long addressId) {
        return mallUserAddressMapper.deleteMallUserAddressById(addressId);
    }

    /**
     * 根据用户id查询用户地址列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<MallUserAddress> findUserAddressListByUserId(Long userId) {
        return mallUserAddressMapper.findUserAddressListByUserId(userId);
    }

    /**
     * 修改用户地址默认状态
     * @param userId
     * @param addressId
     * @return
     */
    @Transactional
    @Override
    public int updateUserAddressStatus(Long userId, Long addressId) {
        mallUserAddressMapper.updateUserAddressStatusById(userId,null,Constants.ADDRESS_STATUS);
        int row = mallUserAddressMapper.updateUserAddressStatusById(userId, addressId, Constants.ADDRESS_STATUS_DEF);
        if (row == 0)
            throw new CustomException("修改失败");
        return row;
    }

}
