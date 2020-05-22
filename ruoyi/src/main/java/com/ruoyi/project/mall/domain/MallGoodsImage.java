package com.ruoyi.project.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商品图片对象 mall_goods_image
 * 
 * @author zhuangcy
 * @date 2020-05-19
 */
public class MallGoodsImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片编号 */
    private Long imageId;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private Long goodsId;

    /** 图片名称 */
    @Excel(name = "图片名称")
    private String imageName;

    /** 图片URL */
    @Excel(name = "图片URL")
    private String url;

    public void setImageId(Long imageId) 
    {
        this.imageId = imageId;
    }

    public Long getImageId() 
    {
        return imageId;
    }
    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
    }
    public void setImageName(String imageName) 
    {
        this.imageName = imageName;
    }

    public String getImageName() 
    {
        return imageName;
    }
    public void setUrl(String imageUrl)
    {
        this.url = imageUrl;
    }

    public String getUrl()
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imageId", getImageId())
            .append("goodsId", getGoodsId())
            .append("imageName", getImageName())
            .append("imageUrl", getUrl())
            .toString();
    }
}
