package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallStore;
import com.ruoyi.project.mall.service.IMallStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 店铺Controller
 * 
 * @author zhuangcy
 * @date 2020-06-02
 */
@RestController
@RequestMapping("/mall/store")
public class MallStoreController extends BaseController
{
    @Autowired
    private IMallStoreService mallStoreService;

    /**
     * 查询店铺列表
     */
    @PreAuthorize("@ss.hasPermi('mall:store:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallStore mallStore)
    {
        startPage();
        List<MallStore> list = mallStoreService.selectMallStoreList(mallStore);
        return getDataTable(list);
    }

    /**
     * 导出店铺列表
     */
    @PreAuthorize("@ss.hasPermi('mall:store:export')")
    @Log(title = "店铺", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallStore mallStore)
    {
        List<MallStore> list = mallStoreService.selectMallStoreList(mallStore);
        ExcelUtil<MallStore> util = new ExcelUtil<MallStore>(MallStore.class);
        return util.exportExcel(list, "store");
    }

    /**
     * 获取店铺详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:store:query')")
    @GetMapping(value = "/{storeId}")
    public AjaxResult getInfo(@PathVariable("storeId") Long storeId)
    {
        return AjaxResult.success(mallStoreService.selectMallStoreById(storeId));
    }

    /**
     * 新增店铺
     */
    @PreAuthorize("@ss.hasPermi('mall:store:add')")
    @Log(title = "店铺", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallStore mallStore)
    {
        return toAjax(mallStoreService.insertMallStore(mallStore));
    }

    /**
     * 修改店铺
     */
    @PreAuthorize("@ss.hasPermi('mall:store:edit')")
    @Log(title = "店铺", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallStore mallStore)
    {
        return toAjax(mallStoreService.updateMallStore(mallStore));
    }

    /**
     * 删除店铺
     */
    @PreAuthorize("@ss.hasPermi('mall:store:remove')")
    @Log(title = "店铺", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storeIds}")
    public AjaxResult remove(@PathVariable Long[] storeIds)
    {
        return toAjax(mallStoreService.deleteMallStoreByIds(storeIds));
    }
}
