package com.ruoyi.project.mall.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 店铺对象 mall_store
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public class MallStore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺编号 */
    private Long storeId;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String storeName;

    /** 店铺地址 */
    @Excel(name = "店铺地址")
    private String storeAddress;

    /** 店铺电话 */
    @Excel(name = "店铺电话")
    private String storeTelephone;

    /** 店铺坐标 */
    @Excel(name = "店铺坐标")
    private String storeCoord;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 店铺logo */
    @Excel(name = "店铺logo")
    private String storeUrl;

    /** 需付金额 */
    private BigDecimal totalPrice;

    /** 运费 */
    private BigDecimal freight;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public void setStoreId(Long storeId)
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
    }
    public void setStoreName(String storeName) 
    {
        this.storeName = storeName;
    }

    public String getStoreName() 
    {
        return storeName;
    }
    public void setStoreAddress(String storeAddress) 
    {
        this.storeAddress = storeAddress;
    }

    public String getStoreAddress() 
    {
        return storeAddress;
    }
    public void setStoreTelephone(String storeTelephone) 
    {
        this.storeTelephone = storeTelephone;
    }

    public String getStoreTelephone() 
    {
        return storeTelephone;
    }
    public void setStoreCoord(String storeCoord) 
    {
        this.storeCoord = storeCoord;
    }

    public String getStoreCoord() 
    {
        return storeCoord;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setStoreUrl(String storeUrl) 
    {
        this.storeUrl = storeUrl;
    }

    public String getStoreUrl() 
    {
        return storeUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("storeAddress", getStoreAddress())
            .append("storeTelephone", getStoreTelephone())
            .append("storeCoord", getStoreCoord())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("storeUrl", getStoreUrl())
            .toString();
    }
}
