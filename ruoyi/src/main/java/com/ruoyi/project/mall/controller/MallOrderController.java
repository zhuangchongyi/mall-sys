package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallOrder;
import com.ruoyi.project.mall.service.IMallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品订单Controller
 * 
 * @author zhuangcy
 * @date 2020-05-25
 */
@RestController
@RequestMapping("/mall/order")
public class MallOrderController extends BaseController
{
    @Autowired
    private IMallOrderService mallOrderService;

    /**
     * 查询商品订单列表
     */
    @PreAuthorize("@ss.hasPermi('mall:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallOrder mallOrder)
    {
        startPage();
        List<MallOrder> list = mallOrderService.selectMallOrderList(mallOrder);
        return getDataTable(list);
    }

    /**
     * 导出商品订单列表
     */
    @PreAuthorize("@ss.hasPermi('mall:order:export')")
    @Log(title = "商品订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallOrder mallOrder)
    {
        List<MallOrder> list = mallOrderService.selectMallOrderList(mallOrder);
        ExcelUtil<MallOrder> util = new ExcelUtil<MallOrder>(MallOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取商品订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(mallOrderService.selectMallOrderById(orderId));
    }

    /**
     * 新增商品订单
     */
    @PreAuthorize("@ss.hasPermi('mall:order:add')")
    @Log(title = "商品订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallOrder mallOrder)
    {
        return toAjax(mallOrderService.insertMallOrder(mallOrder));
    }

    /**
     * 修改商品订单
     */
    @PreAuthorize("@ss.hasPermi('mall:order:edit')")
    @Log(title = "商品订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallOrder mallOrder)
    {
        return toAjax(mallOrderService.updateMallOrder(mallOrder));
    }

    /**
     * 删除商品订单
     */
    @PreAuthorize("@ss.hasPermi('mall:order:remove')")
    @Log(title = "商品订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(mallOrderService.deleteMallOrderByIds(orderIds));
    }
}
