package com.ruoyi.project.mall.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 微信订单总对象 mall_order_wx
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public class MallOrderWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 微信订单编号 */
    private Long wxOrderId;

    /** 微信订单号 */
    @Excel(name = "微信订单号")
    private String wxOrderNum;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNum;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userId;

    /** 店铺编号 */
    @Excel(name = "店铺编号")
    private Long storeId;

    /** 总计金额 */
    @Excel(name = "总计金额")
    private BigDecimal totalPrice;

    /** 需付金额 */
    @Excel(name = "需付金额")
    private BigDecimal wantPrice;

    /** 运费 */
    @Excel(name = "运费")
    private BigDecimal freight;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setWxOrderId(Long wxOrderId) 
    {
        this.wxOrderId = wxOrderId;
    }

    public Long getWxOrderId() 
    {
        return wxOrderId;
    }
    public void setWxOrderNum(String wxOrderNum) 
    {
        this.wxOrderNum = wxOrderNum;
    }

    public String getWxOrderNum() 
    {
        return wxOrderNum;
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
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setWantPrice(BigDecimal wantPrice) 
    {
        this.wantPrice = wantPrice;
    }

    public BigDecimal getWantPrice() 
    {
        return wantPrice;
    }
    public void setFreight(BigDecimal freight) 
    {
        this.freight = freight;
    }

    public BigDecimal getFreight() 
    {
        return freight;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("wxOrderId", getWxOrderId())
            .append("wxOrderNum", getWxOrderNum())
            .append("orderNum", getOrderNum())
            .append("userId", getUserId())
            .append("storeId", getStoreId())
            .append("totalPrice", getTotalPrice())
            .append("wantPrice", getWantPrice())
            .append("freight", getFreight())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
