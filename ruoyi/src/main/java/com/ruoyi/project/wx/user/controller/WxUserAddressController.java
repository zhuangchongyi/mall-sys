package com.ruoyi.project.wx.user.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.mall.domain.MallUserAddress;
import com.ruoyi.project.mall.service.IMallUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author zhuangchongyi
 * @Description 微信用户Controller
 * @Date 2020/6/3 9:53
 */
@RestController
@RequestMapping("/wx/address")
public class WxUserAddressController extends BaseController {
    @Autowired
    private IMallUserAddressService userAddressService;

    /**
     * 查询用户地址列表
     *
     * @param userId
     * @return
     */
    @GetMapping
    public AjaxResult list(@RequestParam("userId") @NotNull(message = "用户编号不允许为空") Long userId) {
        List<MallUserAddress> list = userAddressService.findUserAddressListByUserId(userId);
        return AjaxResult.success(list);
    }

    /**
     * 添加或修改用户地址
     *
     * @param userAddress
     * @return
     */
    @PostMapping
    public AjaxResult saveOrUpdateAddress(@RequestBody MallUserAddress userAddress) {
        if (userAddress.getAddressId() == null) {
            userAddressService.insertMallUserAddress(userAddress);
        } else {
            userAddressService.updateMallUserAddress(userAddress);
        }
        return AjaxResult.success();
    }

    /**
     * 修改默认地址状态
     *
     * @param userId
     * @param addressId
     * @return
     */
    @PutMapping("/{userId}/{addressId}")
    public AjaxResult updateStatus(@PathVariable("userId") Long userId, @PathVariable("addressId") Long addressId) {
        return toAjax(userAddressService.updateUserAddressStatus(userId, addressId));
    }

    /**
     * 删除用户地址
     *
     * @param addressId
     * @return
     */
    @DeleteMapping("/{addressId}")
    public AjaxResult delete(@PathVariable("addressId") Long addressId) {
        return toAjax(userAddressService.deleteMallUserAddressById(addressId));
    }

}
