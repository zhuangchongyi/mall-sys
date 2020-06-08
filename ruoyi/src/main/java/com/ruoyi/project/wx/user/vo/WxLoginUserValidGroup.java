package com.ruoyi.project.wx.user.vo;

import javax.validation.groups.Default;

public class WxLoginUserValidGroup {
    /**
     * 微信用户登录
     */
    public interface WxLogin extends Default {

    }

    /**
     * 手机号码登录用户
     */
    public interface PhoneRegister extends Default {
    }

    /**
     * 手机号码注册用户
     */
    public interface PhoneLogin extends Default {

    }

}
