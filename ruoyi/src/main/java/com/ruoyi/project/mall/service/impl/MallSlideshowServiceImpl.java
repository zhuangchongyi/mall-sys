package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.project.mall.domain.MallSlideshow;
import com.ruoyi.project.mall.mapper.MallSlideshowMapper;
import com.ruoyi.project.mall.service.IMallSlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-05-20
 */
@Service
public class MallSlideshowServiceImpl implements IMallSlideshowService 
{
    @Autowired
    private MallSlideshowMapper mallSlideshowMapper;
    @Autowired
    private RedisCache redisCache;
    /**
     * 查询轮播图
     * 
     * @param slideshowId 轮播图ID
     * @return 轮播图
     */
    @Override
    public MallSlideshow selectMallSlideshowById(Long slideshowId)
    {
        return mallSlideshowMapper.selectMallSlideshowById(slideshowId);
    }

    /**
     * 查询轮播图列表
     * 
     * @param mallSlideshow 轮播图
     * @return 轮播图
     */
    @Override
    public List<MallSlideshow> selectMallSlideshowList(MallSlideshow mallSlideshow)
    {
        return mallSlideshowMapper.selectMallSlideshowList(mallSlideshow);
    }

    /**
     * 新增轮播图
     * 
     * @param mallSlideshow 轮播图
     * @return 结果
     */
    @Override
    public int insertMallSlideshow(MallSlideshow mallSlideshow)
    {
        redisCache.deleteObject("mallSlideshowsCache");
        mallSlideshow.setCreateBy(SecurityUtils.getUsername());
        mallSlideshow.setCreateTime(DateUtils.getNowDate());
        return mallSlideshowMapper.insertMallSlideshow(mallSlideshow);
    }

    /**
     * 修改轮播图
     * 
     * @param mallSlideshow 轮播图
     * @return 结果
     */
    @Override
    public int updateMallSlideshow(MallSlideshow mallSlideshow)
    {
        redisCache.deleteObject("mallSlideshowsCache");
        return mallSlideshowMapper.updateMallSlideshow(mallSlideshow);
    }

    /**
     * 批量删除轮播图
     * 
     * @param slideshowIds 需要删除的轮播图ID
     * @return 结果
     */
    @Override
    public int deleteMallSlideshowByIds(Long... slideshowIds)
    {
        redisCache.deleteObject("mallSlideshowsCache");
        List<String> list = mallSlideshowMapper.selectUrlList(slideshowIds);
        int row = mallSlideshowMapper.deleteMallSlideshowByIds(slideshowIds);
        FileUploadUtils.deleteFiles(list.toArray(new String[list.size()]));
        return row;
    }

    @Override
    public boolean countStatus(MallSlideshow mallSlideshow) {
        if (mallSlideshowMapper.countStatus() >= 5)
            return false;
        return true;
    }

    @Override
    public List<MallSlideshow> selectSlideshowListByStatus() {
        List<MallSlideshow> mallSlideshows = mallSlideshowMapper.selectMallSlideshow();
        redisCache.setCacheList("mallSlideshowsCache" ,mallSlideshows);
        return mallSlideshows;
    }
}
