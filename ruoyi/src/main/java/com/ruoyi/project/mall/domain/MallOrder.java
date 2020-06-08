package com.ruoyi.project.mall.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商品订单对象 mall_order
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public class MallOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    private Long orderId;

    /** 订单号 */
    private String orderNum;

    /** 总计金额 */
    @Excel(name = "总计金额")
    private BigDecimal totalPrice;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private BigDecimal payPrice;

    /** 运费 */
    @Excel(name = "运费")
    private BigDecimal freight;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String status;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private String payStatus;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm")
    private Date payTime;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm")
    private Date deliveryTime;

    /** 收货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @Excel(name = "收货时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm")
    private Date receivingTime;

    /** 下单人编号 */
    @Excel(name = "下单人编号")
    private Long userId;

    /** 收件地址编号 */
    @Excel(name = "收件地址编号")
    private Long orderAddressId;

    /** 店铺编号 */
    @Excel(name = "店铺编号")
    private Long storeId;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String storeName;

    /** 店铺logo */
    @Excel(name = "店铺logo")
    private String storeUrl;

    // 订单明细
    private List<MallOrderDetail> orderDetails;

    // 微信交易订单
    private MallOrderWx orderWx;

    public MallOrderWx getOrderWx() {
        return orderWx;
    }

    public void setOrderWx(MallOrderWx orderWx) {
        this.orderWx = orderWx;
    }

    public List<MallOrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<MallOrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setPayPrice(BigDecimal payPrice) 
    {
        this.payPrice = payPrice;
    }

    public BigDecimal getPayPrice() 
    {
        return payPrice;
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
    public void setPayStatus(String payStatus) 
    {
        this.payStatus = payStatus;
    }

    public String getPayStatus() 
    {
        return payStatus;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }
    public void setDeliveryTime(Date deliveryTime) 
    {
        this.deliveryTime = deliveryTime;
    }

    public Date getDeliveryTime() 
    {
        return deliveryTime;
    }
    public void setReceivingTime(Date receivingTime) 
    {
        this.receivingTime = receivingTime;
    }

    public Date getReceivingTime() 
    {
        return receivingTime;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setOrderAddressId(Long orderAddressId) 
    {
        this.orderAddressId = orderAddressId;
    }

    public Long getOrderAddressId() 
    {
        return orderAddressId;
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
            .append("orderId", getOrderId())
            .append("orderNum", getOrderNum())
            .append("totalPrice", getTotalPrice())
            .append("payPrice", getPayPrice())
            .append("freight", getFreight())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("payStatus", getPayStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("payTime", getPayTime())
            .append("deliveryTime", getDeliveryTime())
            .append("receivingTime", getReceivingTime())
            .append("userId", getUserId())
            .append("orderAddressId", getOrderAddressId())
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("storeUrl", getStoreUrl())
            .toString();
    }
}
