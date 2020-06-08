package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.mall.domain.MallUser;
import com.ruoyi.project.mall.mapper.MallUserMapper;
import com.ruoyi.project.mall.service.IMallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员用户Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-05-25
 */
@Service
public class MallUserServiceImpl implements IMallUserService 
{
    @Autowired
    private MallUserMapper mallUserMapper;

    /**
     * 查询会员用户
     * 
     * @param userId 会员用户ID
     * @return 会员用户
     */
    @Override
    public MallUser selectMallUserById(Long userId)
    {
        MallUser user = mallUserMapper.selectMallUserById(userId);
        if (UserConstants.USER_DISABLE.equals(user.getStatus())){
            throw new CustomException("该用户已被禁用", HttpStatus.UNAUTHORIZED);
        } else if (user == null){
            throw new CustomException("未找到该用户", HttpStatus.UNAUTHORIZED);
        }
        return user;
    }

    /**
     * 查询会员用户列表
     * 
     * @param mallUser 会员用户
     * @return 会员用户
     */
    @Override
    public List<MallUser> selectMallUserList(MallUser mallUser)
    {
        return mallUserMapper.selectMallUserList(mallUser);
    }

    /**
     * 新增会员用户
     * 
     * @param mallUser 会员用户
     * @return 结果
     */
    @Override
    public int insertMallUser(MallUser mallUser)
    {
        mallUser.setCreateTime(DateUtils.getNowDate());
        return mallUserMapper.insertMallUser(mallUser);
    }

    /**
     * 修改会员用户
     * 
     * @param mallUser 会员用户
     * @return 结果
     */
    @Override
    public int updateMallUser(MallUser mallUser)
    {
        mallUser.setUpdateTime(DateUtils.getNowDate());
        return mallUserMapper.updateMallUser(mallUser);
    }

    /**
     * 批量删除会员用户
     * 
     * @param userIds 需要删除的会员用户ID
     * @return 结果
     */
    @Override
    public int deleteMallUserByIds(Long[] userIds)
    {
        return mallUserMapper.deleteMallUserByIds(userIds);
    }

    /**
     * 删除会员用户信息
     * 
     * @param userId 会员用户ID
     * @return 结果
     */
    @Override
    public int deleteMallUserById(Long userId)
    {
        return mallUserMapper.deleteMallUserById(userId);
    }

    /**
     * 校验用户唯一性
     * @param user
     * @return
     */
    @Override
    public boolean checkMallUserUnique(MallUser user) {
        Integer row = mallUserMapper.checkMallUserUnique(user);
        if (row == null)
            return false;
        return true;
    }

    /**
     * 校验邀请码
     * @param inviteCode
     * @return
     */
    @Override
    public boolean checkUserInviteCodeUnique(String inviteCode) {
        Integer row = mallUserMapper.checkUserInviteCodeUnique(inviteCode);
        if (row == null)
            return false;
        return true;
    }

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    @Override
    public MallUser findMallUserByPhone(String phone) {
        return mallUserMapper.oneMallUserByPhone(phone);
    }
}
