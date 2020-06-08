package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallOrderAddress;
import com.ruoyi.project.mall.service.IMallOrderAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单收货地址Controller
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
@RestController
@RequestMapping("/mall/user/address")
public class MallOrderAddressController extends BaseController
{
    @Autowired
    private IMallOrderAddressService mallOrderAddressService;

    /**
     * 查询订单收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('mall:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallOrderAddress mallOrderAddress)
    {
        startPage();
        List<MallOrderAddress> list = mallOrderAddressService.selectMallOrderAddressList(mallOrderAddress);
        return getDataTable(list);
    }

    /**
     * 导出订单收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('mall:address:export')")
    @Log(title = "订单收货地址", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallOrderAddress mallOrderAddress)
    {
        List<MallOrderAddress> list = mallOrderAddressService.selectMallOrderAddressList(mallOrderAddress);
        ExcelUtil<MallOrderAddress> util = new ExcelUtil<MallOrderAddress>(MallOrderAddress.class);
        return util.exportExcel(list, "address");
    }

    /**
     * 获取订单收货地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:address:query')")
    @GetMapping(value = "/{orderAddressId}")
    public AjaxResult getInfo(@PathVariable("orderAddressId") Long orderAddressId)
    {
        return AjaxResult.success(mallOrderAddressService.selectMallOrderAddressById(orderAddressId));
    }

    /**
     * 新增订单收货地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:add')")
    @Log(title = "订单收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallOrderAddress mallOrderAddress)
    {
        return toAjax(mallOrderAddressService.insertMallOrderAddress(mallOrderAddress));
    }

    /**
     * 修改订单收货地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:edit')")
    @Log(title = "订单收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallOrderAddress mallOrderAddress)
    {
        return toAjax(mallOrderAddressService.updateMallOrderAddress(mallOrderAddress));
    }

    /**
     * 删除订单收货地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:remove')")
    @Log(title = "订单收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderAddressIds}")
    public AjaxResult remove(@PathVariable Long[] orderAddressIds)
    {
        return toAjax(mallOrderAddressService.deleteMallOrderAddressByIds(orderAddressIds));
    }
}
