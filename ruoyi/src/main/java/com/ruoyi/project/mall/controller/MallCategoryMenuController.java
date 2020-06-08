package com.ruoyi.project.mall.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.mall.domain.MallCategoryMenu;
import com.ruoyi.project.mall.service.IMallCategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类Controller
 * 
 * @author zhuangcy
 * @date 2020-05-24
 */
@RestController
@RequestMapping("/mall/category")
public class MallCategoryMenuController extends BaseController
{
    @Autowired
    private IMallCategoryMenuService mallCategoryMenuService;

    /**
     * 查询商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('mall:category:list')")
    @GetMapping("/list")
    public AjaxResult list(MallCategoryMenu mallCategoryMenu)
    {
        List<MallCategoryMenu> list = mallCategoryMenuService.selectMallCategoryMenuList(mallCategoryMenu);
        return AjaxResult.success(list);
    }

    /**
     * 获取商品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return AjaxResult.success(mallCategoryMenuService.selectMallCategoryMenuById(categoryId));
    }

    /**
     * 新增商品分类
     */
    @PreAuthorize("@ss.hasPermi('mall:category:add')")
    @Log(title = "添加商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallCategoryMenu mallCategoryMenu)
    {
        if (UserConstants.NOT_UNIQUE.equals(mallCategoryMenuService.checkCategoryNameUnique(mallCategoryMenu)))
        {
            return AjaxResult.error("新增商品分类'" + mallCategoryMenu.getCategoryName() + "'失败，商品分类名称已存在");
        }
        return toAjax(mallCategoryMenuService.insertMallCategoryMenu(mallCategoryMenu));
    }

    /**
     * 修改商品分类
     */
    @PreAuthorize("@ss.hasPermi('mall:category:edit')")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallCategoryMenu mallCategoryMenu)
    {
        return toAjax(mallCategoryMenuService.updateMallCategoryMenu(mallCategoryMenu));
    }

    /**
     * 删除商品分类
     */
    @PreAuthorize("@ss.hasPermi('mall:category:remove')")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long categoryIds)
    {
        if (mallCategoryMenuService.hasChildByCategoryId(categoryIds))
        {
            return AjaxResult.error("存在下级商品分类,不允许删除");
        }
//        if (mallCategoryMenuService.checkCategoryExistGoods(categoryIds))
//        {
//            return AjaxResult.error("该分类存在关联商品,不允许删除");
//        }
        return toAjax(mallCategoryMenuService.deleteMallCategoryMenuById(categoryIds));
    }
}
