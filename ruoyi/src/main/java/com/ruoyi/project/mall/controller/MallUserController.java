package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.mall.domain.MallUser;
import com.ruoyi.project.mall.service.IMallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员用户Controller
 * 
 * @author zhuangcy
 * @date 2020-05-25
 */
@RestController
@RequestMapping("/mall/user")
public class MallUserController extends BaseController
{
    @Autowired
    private IMallUserService mallUserService;

    /**
     * 查询会员用户列表
     */
    @PreAuthorize("@ss.hasPermi('mall:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallUser mallUser)
    {
        startPage();
        List<MallUser> list = mallUserService.selectMallUserList(mallUser);
        return getDataTable(list);
    }

    /**
     * 导出会员用户列表
     */
    @PreAuthorize("@ss.hasPermi('mall:user:export')")
    @Log(title = "会员用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallUser mallUser)
    {
        List<MallUser> list = mallUserService.selectMallUserList(mallUser);
        ExcelUtil<MallUser> util = new ExcelUtil<MallUser>(MallUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 获取会员用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(mallUserService.selectMallUserById(userId));
    }

    /**
     * 新增会员用户
     */
    @PreAuthorize("@ss.hasPermi('mall:user:add')")
    @Log(title = "会员用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallUser mallUser)
    {
        return toAjax(mallUserService.insertMallUser(mallUser));
    }

    /**
     * 修改会员用户
     */
    @PreAuthorize("@ss.hasPermi('mall:user:edit')")
    @Log(title = "会员用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallUser mallUser)
    {
        return toAjax(mallUserService.updateMallUser(mallUser));
    }

    /**
     * 删除会员用户
     */
    @PreAuthorize("@ss.hasPermi('mall:user:remove')")
    @Log(title = "会员用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(mallUserService.deleteMallUserByIds(userIds));
    }
}
