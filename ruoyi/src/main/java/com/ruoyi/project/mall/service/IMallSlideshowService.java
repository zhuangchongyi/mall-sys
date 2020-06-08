package com.ruoyi.project.mall.service;

import com.ruoyi.project.mall.domain.MallSlideshow;

import java.util.List;

/**
 * 轮播图Service接口
 * 
 * @author zhuangcy
 * @date 2020-05-20
 */
public interface IMallSlideshowService 
{
    /**
     * 查询轮播图
     * 
     * @param slideshowId 轮播图ID
     * @return 轮播图
     */
    public MallSlideshow selectMallSlideshowById(Long slideshowId);

    /**
     * 查询轮播图列表
     * 
     * @param mallSlideshow 轮播图
     * @return 轮播图集合
     */
    public List<MallSlideshow> selectMallSlideshowList(MallSlideshow mallSlideshow);

    /**
     * 新增轮播图
     * 
     * @param mallSlideshow 轮播图
     * @return 结果
     */
    public int insertMallSlideshow(MallSlideshow mallSlideshow);

    /**
     * 修改轮播图
     * 
     * @param mallSlideshow 轮播图
     * @return 结果
     */
    public int updateMallSlideshow(MallSlideshow mallSlideshow);

    /**
     * 批量删除轮播图
     * 
     * @param slideshowIds 需要删除的轮播图ID
     * @return 结果
     */
    public int deleteMallSlideshowByIds(Long[] slideshowIds);

    /**
     * 统计状态
     * @param mallSlideshow
     * @return
     */
    boolean countStatus(MallSlideshow mallSlideshow);

    /**
     * 查询启用的轮播图列表
     *
     * @return 轮播图集合
     */
    int selectSlideshowListByStatus();
}
