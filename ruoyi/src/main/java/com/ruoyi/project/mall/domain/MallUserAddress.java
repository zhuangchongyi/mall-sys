package com.ruoyi.project.mall.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;

/**
 * 用户地址对象 mall_user_address
 * 
 * @author zhuangcy
 * @date 2020-06-03
 */
public class MallUserAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地址编号 */
    private Long addressId;

    /** 用户编号 */
    @Excel(name = "用户编号")
    @NotNull(message = "用户编码不能为空")
    private Long userId;

    /** 收件人 */
    @NotNull(message = "收件人不能为空")
    @Excel(name = "收件人")
    private String name;

    /** 收件人电话 */
    @NotNull(message = "手机号码不能为空")
    @Excel(name = "收件人电话")
    private String phone;

    /** 收件地址 */
    @Excel(name = "收件地址")
    private String addr;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 省 */
    @Excel(name = "省")
    @NotNull(message = "未选择省份")
    private String province;

    /** 市 */
    @Excel(name = "市")
    @NotNull(message = "未选择城市")
    private String city;

    /** 区/县 */
    @Excel(name = "区/县")
    @NotNull(message = "未选择区级")
    private String district;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detail;

    /** 默认状态 */
    @Excel(name = "默认状态")
    private String status;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setDistrict(String district) 
    {
        this.district = district;
    }

    public String getDistrict() 
    {
        return district;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("addressId", getAddressId())
                .append("userId", getUserId())
                .append("name", getName())
                .append("phone", getPhone())
                .append("addr", getAddr())
                .append("country", getCountry())
                .append("province", getProvince())
                .append("city", getCity())
                .append("district", getDistrict())
                .append("detail", getDetail())
                .append("postalCode", getPostalCode())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .toString();
    }
}
