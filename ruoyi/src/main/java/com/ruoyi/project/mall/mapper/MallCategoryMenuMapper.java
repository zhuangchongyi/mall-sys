package com.ruoyi.project.mall.mapper;

import com.ruoyi.project.mall.domain.MallCategoryMenu;

import java.util.List;

/**
 * 商品分类Mapper接口
 * 
 * @author zhuangcy
 * @date 2020-05-24
 */
public interface MallCategoryMenuMapper 
{
    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类ID
     * @return 商品分类
     */
    public MallCategoryMenu selectMallCategoryMenuById(Long categoryId);

    /**
     * 查询商品分类列表
     * 
     * @param mallCategoryMenu 商品分类
     * @return 商品分类集合
     */
    public List<MallCategoryMenu> selectMallCategoryMenuList(MallCategoryMenu mallCategoryMenu);

    /**
     * 新增商品分类
     * 
     * @param mallCategoryMenu 商品分类
     * @return 结果
     */
    public int insertMallCategoryMenu(MallCategoryMenu mallCategoryMenu);

    /**
     * 修改商品分类
     * 
     * @param mallCategoryMenu 商品分类
     * @return 结果
     */
    public int updateMallCategoryMenu(MallCategoryMenu mallCategoryMenu);

    /**
     * 删除商品分类
     * 
     * @param categoryId 商品分类ID
     * @return 结果
     */
    public int deleteMallCategoryMenuById(Long categoryId);

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallCategoryMenuByIds(Long[] categoryIds);

    /**
     * 校验商品分类是否唯一
     * @param mallCategoryMenu
     */
    MallCategoryMenu checkCategoryNameUnique(MallCategoryMenu mallCategoryMenu);

    int hasChildByCategoryId(Long categoryIds);
}
