package com.ruoyi.project.mall.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallGoods;
import com.ruoyi.project.mall.service.IMallGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理Controller
 * 
 * @author zhuangcy
 * @date 2020-05-14
 */
@RestController
@RequestMapping("/mall/goods")
public class MallGoodsController extends BaseController
{
    @Autowired
    private IMallGoodsService mallGoodsService;

    /**
     * 查询商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallGoods mallGoods)
    {
        startPage();
        List<MallGoods> list = mallGoodsService.selectMallGoodsList(mallGoods);
        return getDataTable(list);
    }

    /**
     * 获取商品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(mallGoodsService.selectMallGoodsById(goodsId));
    }

    /**
     * 新增商品管理
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:add')")
    @Log(title = "新增商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallGoods mallGoods)
    {
        return toAjax(mallGoodsService.insertMallGoods(mallGoods));
    }

    /**
     * 修改商品管理
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:edit')")
    @Log(title = "修改商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallGoods mallGoods)
    {
        return toAjax(mallGoodsService.updateMallGoods(mallGoods));
    }

    /**
     * 删除商品管理
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:remove')")
    @Log(title = "删除商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(mallGoodsService.deleteMallGoodsByIds(goodsIds));
    }

    /**
     * 批量修改商品状态
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:putaway')")
    @Log(title = "批量修改商品状态", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus/{goodsIds}/{status}")
    public AjaxResult changeStatus(@PathVariable("goodsIds") Integer[] goodsIds,@PathVariable Integer status)
    {
        return toAjax(mallGoodsService.updateSelectMallGoods(goodsIds,status));
    }

}
