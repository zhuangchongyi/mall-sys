package com.ruoyi.project.wx.user.service.impl;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.exception.user.CaptchaException;
import com.ruoyi.common.exception.user.CaptchaExpireException;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.common.utils.*;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.project.mall.domain.MallUser;
import com.ruoyi.project.mall.service.IMallUserService;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.project.wx.user.authentication.WxAuthenticationProvider;
import com.ruoyi.project.wx.user.service.IWxLoginService;
import com.ruoyi.project.wx.user.vo.WxLoginUserVo;
import com.ruoyi.project.wx.utils.WxConfigUtil;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhuangchongyi
 * @Description 微信登录请求Services业务处理
 * @Date 0:38 2020/5/29
 **/
@Service
public class WxLoginServiceImpl implements IWxLoginService {
    private static Logger log = LoggerFactory.getLogger(WxLoginServiceImpl.class);
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private IMallUserService mallUserService;
    @Autowired
    private TokenService tokenService;
    @Resource
    private WxAuthenticationProvider authenticate;

    /**
     * 获取微信用户openid
     *
     * @return void
     * @Author zhuangchongyi
     * @Description 获取微信openid
     * @Date 0:47 2020/5/29
     * @Param [code]
     **/
    @Override
    public String getWxOpenId(String code) {
        Map<String, Object> map = new HashMap<>();
        map.put("appid", WxConfigUtil.APP_ID);
        map.put("secret", WxConfigUtil.APP_SECRET);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String result = HttpUtils.sendGet(WxConfigUtil.URL, StringUtils.joinMapToString(map));
        log.info(result);
        return result;
    }

    /**
     * 获取手机验证码
     *
     * @param phone 手机号码
     * @return
     */
    @Override
    public String getCode(String phone) {
        String code = VerifyCodeUtils.generateVerifyCode(6, VerifyCodeUtils.NUMBER_CODES);
        // 发送短信业务
        String key = Constants.CAPTCHA_CODE_KEY + phone;
        redisCache.setCacheObject(key, code, Constants.CAPTCHA_EXPIRATION_PHONE, TimeUnit.MINUTES); // 过期时间为5分钟
        log.info("发送短信给" + phone + "，验证码为：" + code);
        return code;
    }

    /**
     * 用户注册登录
     *
     * @param vo
     */
    @Transactional
    @Override
    public void register(WxLoginUserVo vo) {
        // 校验手机验证码
        String key = Constants.CAPTCHA_CODE_KEY + vo.getPhone();
        String resCode = redisCache.getCacheObject(key);
        if (StringUtils.isEmpty(resCode)) //失效
            throw new CaptchaExpireException();
        if (!resCode.equals(vo.getCode())) // 错误
            throw new CaptchaException();

        MallUser user = new MallUser();
        BeanUtils.copyProperties(vo, user);
        Map<String, Object> info = vo.getInfo();
        user.setUserName(ObjectUtils.toString(vo.getPhone()));
        user.setNickName(ObjectUtils.toString(info.get("nickName")));
        user.setUrl(ObjectUtils.toString(info.get("avatarUrl")));
        user.setGender(ObjectUtils.toString(info.get("gender")));
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setInviteCode(getInviteCodeValue());
        user.setCreateBy("wx");

        if (mallUserService.checkMallUserUnique(user)) {
            throw new CustomException("该号码已经注册过,请前往登录", HttpStatus.SEE_OTHER);
        }

        /* 注册用户 */
        int row = mallUserService.insertMallUser(user);
        if (row < 1) {
            throw new CustomException("注册失败");
        }
        log.info(vo.getPhone() + ",注册成功");
    }

    /**
     * 获取邀请码
     *
     * @return
     */
    private String getInviteCodeValue() {
        String inviteCode = IdUtils.simpleUUID().substring(0, 10);
        while (mallUserService.checkUserInviteCodeUnique(inviteCode)) {
            log.info("inviteCode repetition, " + inviteCode);
            inviteCode = IdUtils.simpleUUID().substring(0, 10);
        }
        return inviteCode;
    }

    /**
     * 用户登录
     *
     * @param vo
     * @return
     */
    @Override
    public HashMap<String, Object> loginUser(WxLoginUserVo vo) {
        // 用户验证
        Authentication authentication = null;
        String phone = vo.getPhone();
        try {
            authentication = authenticate.authenticate(new UsernamePasswordAuthenticationToken(phone, vo.getPassword()));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(phone, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(phone, Constants.LOGIN_FAIL, e.getMessage()));
                throw new CustomException(e.getMessage());
            }
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(phone, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        MallUser user = (MallUser) authentication.getPrincipal();
        // 生成token
        LoginUser loginUser = new LoginUser();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(vo.getPhone());
        loginUser.setUser(sysUser);
        String token = tokenService.createToken(loginUser);

        HashMap<String, Object> resMap = new HashMap<>();
        user.setPassword(null);
        resMap.put("mallUser", user);
        resMap.put("token", token);
        return resMap;
    }
}
