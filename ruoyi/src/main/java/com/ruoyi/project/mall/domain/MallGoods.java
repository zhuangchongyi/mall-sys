package com.ruoyi.project.mall.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 商品管理对象 mall_goods
 * 
 * @author zhuangcy
 * @date 2020-05-14
 */
public class MallGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long goodsId;

    /** 店铺id-外键 */
    @Excel(name = "店铺id-外键")
    private Long storeId;

    /** 商品主标题 */
    @Excel(name = "商品主标题")
    private String mainTitle;

    /** 商品副标题 */
    @Excel(name = "商品副标题")
    private String subTitle;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Double price;

    /** 商品原价 */
    @Excel(name = "商品原价")
    private Double oldPrice;

    /** 封面图 */
    @Excel(name = "封面图")
    private String goodsImg;

    /** 上架状态 */
    @Excel(name = "上架状态")
    private Integer status;

    /** 逻辑删除 */
    private Integer delFlag;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
    }
    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
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
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }
    public void setOldPrice(Double oldPrice) 
    {
        this.oldPrice = oldPrice;
    }

    public Double getOldPrice() 
    {
        return oldPrice;
    }
    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsImg()
    {
        return goodsImg;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("storeId", getStoreId())
            .append("mainTitle", getMainTitle())
            .append("subTitle", getSubTitle())
            .append("price", getPrice())
            .append("oldPrice", getOldPrice())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("updateDate", getUpdateDate())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
