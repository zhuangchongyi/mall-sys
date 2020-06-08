package com.ruoyi.project.wx.user.service;

import com.ruoyi.project.wx.user.vo.WxLoginUserVo;

import java.util.HashMap;

/**
 * @Author zhuangchongyi
 * @Description 微信登录请求Service
 * @Date 0:38 2020/5/29
 **/
public interface IWxLoginService {
    /**
     * 获取验证码
     * @param phone 手机号码
     * @return
     */
    String getCode(String phone);

    /**
     * 用户登录
     * @param vo
     * @return
     */
    HashMap<String, Object> loginUser(WxLoginUserVo vo);

    /**
     * 注册登录
     * @param vo
     */
    void register(WxLoginUserVo vo);

    /**
     * 获取微信微信openid
     * @param code
     * @return
     */
    String getWxOpenId(String code);
}
