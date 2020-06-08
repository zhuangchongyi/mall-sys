package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallOrderWx;
import com.ruoyi.project.mall.service.IMallOrderWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信订单总Controller
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
@RestController
@RequestMapping("/mall/wx")
public class MallOrderWxController extends BaseController
{
    @Autowired
    private IMallOrderWxService mallOrderWxService;

    /**
     * 查询微信订单总列表
     */
    @PreAuthorize("@ss.hasPermi('mall:wx:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallOrderWx mallOrderWx)
    {
        startPage();
        List<MallOrderWx> list = mallOrderWxService.selectMallOrderWxList(mallOrderWx);
        return getDataTable(list);
    }

    /**
     * 导出微信订单总列表
     */
    @PreAuthorize("@ss.hasPermi('mall:wx:export')")
    @Log(title = "微信订单总", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallOrderWx mallOrderWx)
    {
        List<MallOrderWx> list = mallOrderWxService.selectMallOrderWxList(mallOrderWx);
        ExcelUtil<MallOrderWx> util = new ExcelUtil<MallOrderWx>(MallOrderWx.class);
        return util.exportExcel(list, "wx");
    }

    /**
     * 获取微信订单总详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:wx:query')")
    @GetMapping(value = "/{wxOrderId}")
    public AjaxResult getInfo(@PathVariable("wxOrderId") Long wxOrderId)
    {
        return AjaxResult.success(mallOrderWxService.selectMallOrderWxById(wxOrderId));
    }

    /**
     * 新增微信订单总
     */
    @PreAuthorize("@ss.hasPermi('mall:wx:add')")
    @Log(title = "微信订单总", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallOrderWx mallOrderWx)
    {
        return toAjax(mallOrderWxService.insertMallOrderWx(mallOrderWx));
    }

    /**
     * 修改微信订单总
     */
    @PreAuthorize("@ss.hasPermi('mall:wx:edit')")
    @Log(title = "微信订单总", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallOrderWx mallOrderWx)
    {
        return toAjax(mallOrderWxService.updateMallOrderWx(mallOrderWx));
    }

    /**
     * 删除微信订单总
     */
    @PreAuthorize("@ss.hasPermi('mall:wx:remove')")
    @Log(title = "微信订单总", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wxOrderIds}")
    public AjaxResult remove(@PathVariable Long[] wxOrderIds)
    {
        return toAjax(mallOrderWxService.deleteMallOrderWxByIds(wxOrderIds));
    }
}
