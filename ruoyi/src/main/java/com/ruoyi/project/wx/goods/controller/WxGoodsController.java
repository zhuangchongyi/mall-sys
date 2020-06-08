package com.ruoyi.project.wx.goods.controller;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallGoods;
import com.ruoyi.project.mall.domain.MallGoodsImage;
import com.ruoyi.project.mall.domain.MallStore;
import com.ruoyi.project.mall.service.IMallGoodsImageService;
import com.ruoyi.project.mall.service.IMallGoodsService;
import com.ruoyi.project.mall.service.IMallSlideshowService;
import com.ruoyi.project.mall.service.IMallStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 微信商品 Controller
 *
 * @author zhuangcy
 * @date 2020-05-20
 */
@RestController
@RequestMapping("/wx/goods")
public class WxGoodsController extends BaseController {
    @Autowired
    private IMallSlideshowService mallSlideshowService;
    @Autowired
    private IMallGoodsService mallGoodsService;
    @Autowired
    private IMallGoodsImageService imageService;
    @Autowired
    private IMallStoreService storeService;
    @Autowired
    private RedisCache redisCache;

    /**
     * 查询轮播图列表
     */
    @GetMapping("/banner")
    public AjaxResult banner() {
        List<Object> list = redisCache.getCacheObject(Constants.SLIDESHOW_CACHE);
        if (list != null && !list.isEmpty()) return AjaxResult.success(list);
        return AjaxResult.success(mallSlideshowService.selectSlideshowListByStatus());
    }

    /**
     * 查询轮播图列表
     */
    @GetMapping("/list/{pageSize}/{page}")
    public TableDataInfo list(@PathVariable("pageSize") Integer pageSize, @PathVariable("page") Integer page) {
        System.out.println(pageSize + "=" + page);
        startPage(page, pageSize);
        List<MallGoods> list = mallGoodsService.selectMallGoodsListByStatus();
        return getDataTable(list);
    }

    /**
     * 查询商品明细
     */
    // 这里加个后置通知, 插入一条推荐商品记录,
    @GetMapping("/detail/{goodsId}")
    public AjaxResult detail(@PathVariable("goodsId") Long goodsId) {
        // 查询商品信息
        MallGoods goods = mallGoodsService.selectMallGoodsById(goodsId);
        if (null == goods) AjaxResult.error("该商品已下架");
        // 查询商品图片
        List<MallGoodsImage> images = imageService.findGoodsImageByGoodsId(goodsId);
        // 查询商品店铺信息
        MallStore mallStore = storeService.selectMallStoreById(goods.getStoreId().longValue());
        HashMap<String, Object> map = new HashMap<>();
        map.put("goods", goods);
        map.put("store", mallStore);
        map.put("images", images);
        return AjaxResult.success(map);
    }

}
