package com.ruoyi.project.wx.user.controller;

import com.alibaba.fastjson.JSON;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.mall.service.IMallUserService;
import com.ruoyi.project.wx.user.service.IWxLoginService;
import com.ruoyi.project.wx.user.vo.WxLoginUserValidGroup;
import com.ruoyi.project.wx.user.vo.WxLoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * @Author zhuangchongyi
 * @Description 微信用户Controller
 * @Date 2020/6/3 9:53
 */
@RestController
@RequestMapping("/wx/user")
public class WxUserController {
    @Autowired
    private IWxLoginService loginService;
    @Autowired
    private IMallUserService mallUserService;

    /**
     * @Author zhuangchongyi
     * @Description 获取微信用户openid
     * @Date 0:15 2020/5/29
     **/
    @GetMapping("/openid/{code}")
    public AjaxResult getOpenId(@PathVariable("code") @NotNull String code) {
        String result = loginService.getWxOpenId(code);
        return AjaxResult.success("data", JSON.parse(result));
    }

    /**
     * @Author zhuangchongyi
     * @Description 获取验证码
     * @Date 0:15 2020/5/29
     * @Param [phone]
     **/
    @GetMapping("/code/{phone}")
    public AjaxResult getCode(@PathVariable("phone") @NotNull(message = "请输入手机号码") String phone) {
        String code = loginService.getCode(phone);
        AjaxResult result = AjaxResult.success();
        result.put("data", code);
        return result;
    }

    /**
     * @Author zhuangchongyi
     * @Description 用户登录
     * @Date 0:15 2020/5/29
     **/
    @PostMapping("/login")
    public AjaxResult login(@RequestBody @Validated({WxLoginUserValidGroup.PhoneLogin.class}) WxLoginUserVo vo) {
        HashMap<String, Object> resMap = loginService.loginUser(vo);
        return AjaxResult.success(resMap);
    }
    /**
     * @Author zhuangchongyi
     * @Description 用户登录
     * @Date 0:15 2020/5/29
     **/
    @PostMapping("/logout")
    public AjaxResult logout(@RequestBody @Validated({WxLoginUserValidGroup.PhoneLogin.class}) WxLoginUserVo vo) {
        HashMap<String, Object> resMap = loginService.loginUser(vo);
        return AjaxResult.success(resMap);
    }

    /**
     * @Author: zhuangchongyi
     * @Description: 用户注冊
     * @Date: 2020/5/29 14:51
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody @Validated({WxLoginUserValidGroup.PhoneRegister.class}) WxLoginUserVo vo) {
        loginService.register(vo);
        return AjaxResult.success();
    }

    /**
     * @Author zhuangchongyi
     * @Description 获取验证码
     * @Date 0:15 2020/5/29
     * @Param [phone]
     **/
    @GetMapping("/{userId}")
    public AjaxResult info(@PathVariable("userId") @NotNull Long userId) {
        return AjaxResult.success(mallUserService.selectMallUserById(userId));
    }


}
