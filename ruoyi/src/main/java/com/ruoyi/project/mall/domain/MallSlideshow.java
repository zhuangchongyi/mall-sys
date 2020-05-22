package com.ruoyi.project.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 轮播图对象 mall_slideshow
 * 
 * @author zhuangcy
 * @date 2020-05-20
 */
public class MallSlideshow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图编号 */
    private Long slideshowId;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String url;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    public void setSlideshowId(Long slideshowId) 
    {
        this.slideshowId = slideshowId;
    }

    public Long getSlideshowId() 
    {
        return slideshowId;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("slideshowId", getSlideshowId())
            .append("url", getUrl())
            .append("status", getStatus())
            .append("sort", getSort())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
