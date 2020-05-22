package com.ruoyi.project.mall.controller;

import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallGoods;
import com.ruoyi.project.mall.service.IMallGoodsService;
import com.ruoyi.project.mall.service.IMallSlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信APIController
 *
 * @author zhuangcy
 * @date 2020-05-20
 */
@RestController
@RequestMapping("/wx/api")
public class WxApiController extends BaseController {
    @Autowired
    private IMallSlideshowService mallSlideshowService;
    @Autowired
    private IMallGoodsService mallGoodsService;
    @Autowired
    private RedisCache redisCache;

    /**
     * 查询轮播图列表
     */
    @GetMapping("/banner")
    public AjaxResult banner()
    {
        List<Object> list = redisCache.getCacheList("mallSlideshowsCache");
        if (list != null && !list.isEmpty()) return AjaxResult.success(list);
        return AjaxResult.success(mallSlideshowService.selectSlideshowListByStatus());
    }

    /**
     * 查询轮播图列表
     */
    @GetMapping("/goods/{pageSize}/{page}")
    public TableDataInfo goods(@PathVariable("pageSize") Integer pageSize, @PathVariable("page") Integer page){
        startPage(page,pageSize);
        List<MallGoods> list = mallGoodsService.selectMallGoodsListByStatus();
        return getDataTable(list);
    }
}
