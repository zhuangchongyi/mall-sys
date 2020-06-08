package com.ruoyi.project.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 会员用户对象 mall_user
 *
 * @author zhuangcy
 * @date 2020-05-25
 */
public class MallUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 用户名称
     */
    @Excel(name = "用户名称")
    private String userName;

    /**
     * 用户密码
     */
    @Excel(name = "用户密码")
    private String password;

    /**
     * 别名
     */
    @Excel(name = "别名")
    private String nickName;

    /**
     * 头像
     */
    @Excel(name = "头像")
    private String url;

    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String phone;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 余额
     */
    @Excel(name = "余额")
    private String price;

    /**
     * 积分
     */
    @Excel(name = "积分")
    private String integral;

    /**
     * 邀请码
     */
    @Excel(name = "邀请码")
    private String inviteCode;

    /**
     * 等级
     */
    @Excel(name = "等级")
    private String level;

    /**
     * 微信号
     */
    @Excel(name = "微信号")
    private String wxId;

    /**
     * 微信号
     */
    @Excel(name = "性别")
    private String gender;

    /**
     * 验证码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getIntegral() {
        return integral;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWxId() {
        return wxId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("password", getPassword())
                .append("nickName", getNickName())
                .append("url", getUrl())
                .append("phone", getPhone())
                .append("status", getStatus())
                .append("price", getPrice())
                .append("integral", getIntegral())
                .append("inviteCode", getInviteCode())
                .append("level", getLevel())
                .append("wxId", getWxId())
                .append("gender", getGender())
                .append("code", getCode())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .toString();
    }

}
