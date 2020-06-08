package com.ruoyi.project.wx.order.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.mall.domain.MallOrder;
import com.ruoyi.project.mall.service.IMallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @Author zhuangchongyi
 * @Description 微信订单Controller
 * @Date 2020/6/3 9:53
 */
@RestController
@RequestMapping("/wx/order")
public class WxOrderController extends BaseController {
    @Autowired
    private IMallOrderService orderService;

    /**
     * 添加用户订单
     *
     * @param formMap
     * @return
     */
    @PostMapping
    public AjaxResult addOrder(@RequestBody Map<String, Object> formMap) {
        Map<String, Object> resMap = orderService.saveUserOrder(formMap);
        return AjaxResult.success(resMap);
    }

    /**
     * 查询用户订单
     *
     * @param userId
     * @param status
     * @return
     */
    @GetMapping("/u/{userId}/s/{status}")
    public AjaxResult list(@PathVariable("userId") @NotNull Long userId, @PathVariable("status") String status) {
        return AjaxResult.success(orderService.findUserOrderByUserId(userId, status));
    }

    /**
     * 修改订单状态
     *
     * @param mallOrder
     * @return
     */
    @PutMapping
    public AjaxResult updateStatus(@RequestBody MallOrder mallOrder) {
        return toAjax(orderService.updateOrderStatus(mallOrder));
    }


}
