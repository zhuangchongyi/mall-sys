package com.ruoyi.project.wx.user.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

public class WxLoginUserVo implements Serializable {
    private static final long serialVersionUID = -4473373857959369013L;
    @NotNull(message = "手机号码不能为空", groups = {WxLoginUserValidGroup.PhoneLogin.class, WxLoginUserValidGroup.PhoneRegister.class})
    private String phone;
    @NotNull(message = "密码不能为空", groups = {WxLoginUserValidGroup.PhoneLogin.class,WxLoginUserValidGroup.PhoneRegister.class})
    private String password;
    @NotNull(message = "验证码不能为空", groups = {WxLoginUserValidGroup.WxLogin.class, WxLoginUserValidGroup.PhoneRegister.class})
    private String code;
    private Map<String, Object> info;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "WxLoginVo{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", info=" + info +
                '}';
    }
}
