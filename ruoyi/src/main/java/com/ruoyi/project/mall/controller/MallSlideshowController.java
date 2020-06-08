package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallSlideshow;
import com.ruoyi.project.mall.service.IMallSlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 轮播图Controller
 * 
 * @author zhuangcy
 * @date 2020-05-20
 */
@RestController
@RequestMapping("/mall/slideshow")
public class MallSlideshowController extends BaseController
{
    @Autowired
    private IMallSlideshowService mallSlideshowService;
    @Autowired
    private RedisCache redisCache;
    /**
     * 查询轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('mall:slideshow:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallSlideshow mallSlideshow)
    {
        startPage();
        List<MallSlideshow> list = mallSlideshowService.selectMallSlideshowList(mallSlideshow);
        return getDataTable(list);
    }


    /**
     * 获取轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:slideshow:query')")
    @GetMapping(value = "/{slideshowId}")
    public AjaxResult getInfo(@PathVariable("slideshowId") Long slideshowId)
    {
        return AjaxResult.success(mallSlideshowService.selectMallSlideshowById(slideshowId));
    }

    /**
     * 新增轮播图
     */
    @PreAuthorize("@ss.hasPermi('mall:slideshow:add')")
    @Log(title = "新增轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(MallSlideshow mallSlideshow, @RequestParam("file") MultipartFile file) throws IOException {
        String url = FileUploadUtils.upload(RuoYiConfig.getSlideshowPath(), file);
        if (StringUtils.isEmpty(url)) return AjaxResult.error("上传失败");
        mallSlideshow.setUrl(url);
        return toAjax(mallSlideshowService.insertMallSlideshow(mallSlideshow));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('mall:slideshow:edit')")
    @Log(title = "修改轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallSlideshow mallSlideshow)
    {
        return toAjax(mallSlideshowService.updateMallSlideshow(mallSlideshow));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('mall:slideshow:edit')")
    @Log(title = "修改轮播图", businessType = BusinessType.UPDATE)
    @PutMapping("/status")
    public AjaxResult updateStatus(@RequestBody MallSlideshow mallSlideshow)
    {
        if (mallSlideshow.getStatus() !=1 || mallSlideshowService.countStatus(mallSlideshow)){
            return toAjax(mallSlideshowService.updateMallSlideshow(mallSlideshow));
        }
        return AjaxResult.error("启用失败，最多启用5个");
    }

    /**
     * 删除轮播图
     */
    @PreAuthorize("@ss.hasPermi('mall:slideshow:remove')")
    @Log(title = "删除轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{slideshowIds}")
    public AjaxResult remove(@PathVariable Long[] slideshowIds)
    {
        return toAjax(mallSlideshowService.deleteMallSlideshowByIds(slideshowIds));
    }


    /**
     * redis缓存
     */
    @PreAuthorize("@ss.hasPermi('mall:slideshow:edit')")
    @Log(title = "缓存轮播图", businessType = BusinessType.DELETE)
	@PutMapping("/enable")
    public AjaxResult enable()
    {
        return toAjax(mallSlideshowService.selectSlideshowListByStatus());
    }


}
