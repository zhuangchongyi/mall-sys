package com.ruoyi.project.wx.user.authentication;

import com.ruoyi.common.enums.UserStatus;
import com.ruoyi.common.exception.BaseException;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.mall.domain.MallUser;
import com.ruoyi.project.mall.service.IMallUserService;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author zhuangchongyi
 * @Description 校验微信用户访问权限AuthenticationProvider
 * @Date 2020/6/3 9:54
 */
@Component
public class WxAuthenticationProvider implements AuthenticationProvider {
    public static final Logger log = LoggerFactory.getLogger(WxAuthenticationProvider.class);
    @Autowired
    private IMallUserService mallUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String phone = ObjectUtils.toString(authentication.getPrincipal());
        String password = ObjectUtils.toString(authentication.getCredentials());
        MallUser user = mallUserService.findMallUserByPhone(phone);
        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", phone);
            throw new UsernameNotFoundException("登录用户：" + phone + " 不存在");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", phone);
            throw new BaseException("对不起，您的账号：" + phone + " 已停用");
        }
        if (!SecurityUtils.matchesPassword(password, user.getPassword())) { // 密码不正确
            throw new UserPasswordNotMatchException();
        }

        return new WxAuthenticationToken(user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(WxAuthenticationProvider.class);
    }
}
