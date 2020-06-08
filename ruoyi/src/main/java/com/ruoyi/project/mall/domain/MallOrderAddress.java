package com.ruoyi.project.mall.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单收货地址对象 mall_order_address
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public class MallOrderAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地址编号 */
    private Long orderAddressId;

    /** 订单号 */
    private String orderNum;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userId;

    /** 店铺编号 */
    @Excel(name = "店铺编号")
    private Long storeId;

    /** 收件人 */
    @Excel(name = "收件人")
    private String name;

    /** 收件人电话 */
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
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区/县 */
    @Excel(name = "区/县")
    private String district;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detail;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    public void setOrderAddressId(Long orderAddressId) 
    {
        this.orderAddressId = orderAddressId;
    }

    public Long getOrderAddressId() 
    {
        return orderAddressId;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
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
    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("orderAddressId", getOrderAddressId())
            .append("orderNum", getOrderNum())
            .append("userId", getUserId())
            .append("storeId", getStoreId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("addr", getAddr())
            .append("country", getCountry())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("detail", getDetail())
            .append("postalCode", getPostalCode())
            .append("createTime", getCreateTime())
            .toString();
    }
}
