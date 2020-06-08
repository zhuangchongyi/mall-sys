package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallUserAddress;
import com.ruoyi.project.mall.service.IMallUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户地址Controller
 * 
 * @author zhuangcy
 * @date 2020-06-03
 */
@RestController
@RequestMapping("/mall/order/address")
public class MallUserAddressController extends BaseController
{
    @Autowired
    private IMallUserAddressService mallUserAddressService;

    /**
     * 查询用户地址列表
     */
    @PreAuthorize("@ss.hasPermi('mall:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallUserAddress mallUserAddress)
    {
        startPage();
        List<MallUserAddress> list = mallUserAddressService.selectMallUserAddressList(mallUserAddress);
        return getDataTable(list);
    }

    /**
     * 导出用户地址列表
     */
    @PreAuthorize("@ss.hasPermi('mall:address:export')")
    @Log(title = "用户地址", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallUserAddress mallUserAddress)
    {
        List<MallUserAddress> list = mallUserAddressService.selectMallUserAddressList(mallUserAddress);
        ExcelUtil<MallUserAddress> util = new ExcelUtil<MallUserAddress>(MallUserAddress.class);
        return util.exportExcel(list, "address");
    }

    /**
     * 获取用户地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:address:query')")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        return AjaxResult.success(mallUserAddressService.selectMallUserAddressById(addressId));
    }

    /**
     * 新增用户地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:add')")
    @Log(title = "用户地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallUserAddress mallUserAddress)
    {
        return toAjax(mallUserAddressService.insertMallUserAddress(mallUserAddress));
    }

    /**
     * 修改用户地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:edit')")
    @Log(title = "用户地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallUserAddress mallUserAddress)
    {
        return toAjax(mallUserAddressService.updateMallUserAddress(mallUserAddress));
    }

    /**
     * 删除用户地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:remove')")
    @Log(title = "用户地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable Long[] addressIds)
    {
        return toAjax(mallUserAddressService.deleteMallUserAddressByIds(addressIds));
    }
}
