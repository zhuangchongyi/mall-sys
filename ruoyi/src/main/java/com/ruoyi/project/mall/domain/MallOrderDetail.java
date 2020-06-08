package com.ruoyi.project.mall.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品订单明细对象 mall_order_detail
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public class MallOrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单明细编号 */
    private Long orderDetailId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNum;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private Long goodsId;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userId;

    /** 店铺编号 */
    @Excel(name = "店铺编号")
    private Long storeId;

    /** 售价 */
    @Excel(name = "售价")
    private BigDecimal price;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String specsName;

    /** 规格编号 */
    @Excel(name = "规格编号")
    private Long specsId;

    /** 主标题 */
    @Excel(name = "主标题")
    private String mainTitle;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subTitle;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Long num;

    /** 图片 */
    @Excel(name = "图片")
    private String url;


    /** 订单日期 */
    @Excel(name = "订单日期")
    private Date orderTime;

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderDetailId(Long orderDetailId)
    {
        this.orderDetailId = orderDetailId;
    }

    public Long getOrderDetailId() 
    {
        return orderDetailId;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
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
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setSpecsName(String specsName) 
    {
        this.specsName = specsName;
    }

    public String getSpecsName() 
    {
        return specsName;
    }
    public void setSpecsId(Long specsId) 
    {
        this.specsId = specsId;
    }

    public Long getSpecsId() 
    {
        return specsId;
    }
    public void setMainTitle(String mainTitle) 
    {
        this.mainTitle = mainTitle;
    }

    public String getMainTitle() 
    {
        return mainTitle;
    }
    public void setSubTitle(String subTitle) 
    {
        this.subTitle = subTitle;
    }

    public String getSubTitle() 
    {
        return subTitle;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("orderDetailId", getOrderDetailId())
            .append("orderNum", getOrderNum())
            .append("goodsId", getGoodsId())
            .append("userId", getUserId())
            .append("storeId", getStoreId())
            .append("price", getPrice())
            .append("specsName", getSpecsName())
            .append("specsId", getSpecsId())
            .append("mainTitle", getMainTitle())
            .append("subTitle", getSubTitle())
            .append("num", getNum())
            .append("url", getUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
