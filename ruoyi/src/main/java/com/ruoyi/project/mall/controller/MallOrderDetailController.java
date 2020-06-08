package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallOrderDetail;
import com.ruoyi.project.mall.service.IMallOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品订单明细Controller
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
@RestController
@RequestMapping("/mall/order/detail")
public class MallOrderDetailController extends BaseController
{
    @Autowired
    private IMallOrderDetailService mallOrderDetailService;

    /**
     * 查询商品订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('mall:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallOrderDetail mallOrderDetail)
    {
        startPage();
        List<MallOrderDetail> list = mallOrderDetailService.selectMallOrderDetailList(mallOrderDetail);
        return getDataTable(list);
    }

    /**
     * 导出商品订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('mall:detail:export')")
    @Log(title = "商品订单明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallOrderDetail mallOrderDetail)
    {
        List<MallOrderDetail> list = mallOrderDetailService.selectMallOrderDetailList(mallOrderDetail);
        ExcelUtil<MallOrderDetail> util = new ExcelUtil<MallOrderDetail>(MallOrderDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 获取商品订单明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:detail:query')")
    @GetMapping(value = "/{orderDetailId}")
    public AjaxResult getInfo(@PathVariable("orderDetailId") Long orderDetailId)
    {
        return AjaxResult.success(mallOrderDetailService.selectMallOrderDetailById(orderDetailId));
    }

    /**
     * 新增商品订单明细
     */
    @PreAuthorize("@ss.hasPermi('mall:detail:add')")
    @Log(title = "商品订单明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallOrderDetail mallOrderDetail)
    {
        return toAjax(mallOrderDetailService.insertMallOrderDetail(mallOrderDetail));
    }

    /**
     * 修改商品订单明细
     */
    @PreAuthorize("@ss.hasPermi('mall:detail:edit')")
    @Log(title = "商品订单明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallOrderDetail mallOrderDetail)
    {
        return toAjax(mallOrderDetailService.updateMallOrderDetail(mallOrderDetail));
    }

    /**
     * 删除商品订单明细
     */
    @PreAuthorize("@ss.hasPermi('mall:detail:remove')")
    @Log(title = "商品订单明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderDetailIds}")
    public AjaxResult remove(@PathVariable Long[] orderDetailIds)
    {
        return toAjax(mallOrderDetailService.deleteMallOrderDetailByIds(orderDetailIds));
    }
}
