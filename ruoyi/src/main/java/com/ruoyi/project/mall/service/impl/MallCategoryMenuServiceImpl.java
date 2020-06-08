package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.mall.domain.MallCategoryMenu;
import com.ruoyi.project.mall.mapper.MallCategoryMenuMapper;
import com.ruoyi.project.mall.service.IMallCategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-05-24
 */
@Service
public class MallCategoryMenuServiceImpl implements IMallCategoryMenuService 
{
    @Autowired
    private MallCategoryMenuMapper mallCategoryMenuMapper;

    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类ID
     * @return 商品分类
     */
    @Override
    public MallCategoryMenu selectMallCategoryMenuById(Long categoryId)
    {
        return mallCategoryMenuMapper.selectMallCategoryMenuById(categoryId);
    }

    /**
     * 查询商品分类列表
     * 
     * @param mallCategoryMenu 商品分类
     * @return 商品分类
     */
    @Override
    public List<MallCategoryMenu> selectMallCategoryMenuList(MallCategoryMenu mallCategoryMenu)
    {
        return mallCategoryMenuMapper.selectMallCategoryMenuList(mallCategoryMenu);
    }

    /**
     * 新增商品分类
     * 
     * @param mallCategoryMenu 商品分类
     * @return 结果
     */
    @Override
    public int insertMallCategoryMenu(MallCategoryMenu mallCategoryMenu)
    {
        MallCategoryMenu info = mallCategoryMenuMapper.selectMallCategoryMenuById(mallCategoryMenu.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (!UserConstants.UNIQUE.equals(info.getStatus()))
        {
            throw new CustomException("该商品分类已停用，不允许新增");
        }
        mallCategoryMenu.setAncestors(info.getAncestors() + "," + mallCategoryMenu.getParentId());
        mallCategoryMenu.setCreateTime(DateUtils.getNowDate());
        mallCategoryMenu.setCreateBy(SecurityUtils.getUsername());
        return mallCategoryMenuMapper.insertMallCategoryMenu(mallCategoryMenu);
    }

    /**
     * 修改商品分类
     * 
     * @param mallCategoryMenu 商品分类
     * @return 结果
     */
    @Override
    public int updateMallCategoryMenu(MallCategoryMenu mallCategoryMenu)
    {
        mallCategoryMenu.setUpdateTime(DateUtils.getNowDate());
        return mallCategoryMenuMapper.updateMallCategoryMenu(mallCategoryMenu);
    }

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的商品分类ID
     * @return 结果
     */
    @Override
    public int deleteMallCategoryMenuByIds(Long[] categoryIds)
    {
        return mallCategoryMenuMapper.deleteMallCategoryMenuByIds(categoryIds);
    }

    /**
     * 删除商品分类信息
     * 
     * @param categoryId 商品分类ID
     * @return 结果
     */
    @Override
    public int deleteMallCategoryMenuById(Long categoryId)
    {
        return mallCategoryMenuMapper.deleteMallCategoryMenuById(categoryId);
    }

    /**
     * 校验商品分类是否唯一
     * @param mallCategoryMenu
     * @return
     */
    @Override
    public String checkCategoryNameUnique(MallCategoryMenu mallCategoryMenu) {
        MallCategoryMenu categoryMenu = mallCategoryMenuMapper.checkCategoryNameUnique(mallCategoryMenu);
        if (StringUtils.isNotNull(categoryMenu))
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public boolean hasChildByCategoryId(Long categoryIds) {
        return mallCategoryMenuMapper.hasChildByCategoryId(categoryIds) > 0 ? true : false;
    }
}
