package com.ruoyi.project.wx.order.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.mall.domain.MallOrderAddress;
import com.ruoyi.project.mall.service.IMallOrderAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhuangchongyi
 * @Description 微信订单Controller
 * @Date 2020/6/3 9:53
 */
@RestController
@RequestMapping("/wx/order/address")
public class WxOrderAddressController extends BaseController {
    @Autowired
    private IMallOrderAddressService orderAddressService;

    /**
     * 修改订单地址
     * @param orderAddress
     * @return
     */
    @PutMapping
    public AjaxResult updateAddress(@RequestBody MallOrderAddress orderAddress) {
        return toAjax(orderAddressService.updateMallOrderAddress(orderAddress));
    }

    /**
     * 查询订单地址
     * @param orderNum
     * @return
     */
    @GetMapping("/{orderNum}")
    public AjaxResult get(@PathVariable("orderNum")String orderNum) {
        return AjaxResult.success(orderAddressService.findOrderAddressByOrderNum(orderNum));
    }
}
