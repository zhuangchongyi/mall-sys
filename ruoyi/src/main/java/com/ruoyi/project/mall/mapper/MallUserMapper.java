package com.ruoyi.project.mall.mapper;

import com.ruoyi.project.mall.domain.MallUser;

import java.util.List;

/**
 * 会员用户Mapper接口
 * 
 * @author zhuangcy
 * @date 2020-05-25
 */
public interface MallUserMapper 
{
    /**
     * 查询会员用户
     * 
     * @param userId 会员用户ID
     * @return 会员用户
     */
    public MallUser selectMallUserById(Long userId);

    /**
     * 查询会员用户列表
     * 
     * @param mallUser 会员用户
     * @return 会员用户集合
     */
    public List<MallUser> selectMallUserList(MallUser mallUser);

    /**
     * 新增会员用户
     * 
     * @param mallUser 会员用户
     * @return 结果
     */
    public int insertMallUser(MallUser mallUser);

    /**
     * 修改会员用户
     * 
     * @param mallUser 会员用户
     * @return 结果
     */
    public int updateMallUser(MallUser mallUser);

    /**
     * 删除会员用户
     * 
     * @param userId 会员用户ID
     * @return 结果
     */
    public int deleteMallUserById(Long userId);

    /**
     * 批量删除会员用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallUserByIds(Long[] userIds);

    /**
     * 校验是否唯一
     * @param user
     * @return
     */
    Integer checkMallUserUnique(MallUser user);

    /**
     * 校验邀请码唯一性
     * @param inviteCode
     * @return
     */
    Integer checkUserInviteCodeUnique(String inviteCode);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    MallUser oneMallUserByPhone(String phone);
}
