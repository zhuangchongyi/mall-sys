package com.ruoyi.project.mall.service;

import com.ruoyi.project.mall.domain.MallGoods;

import java.util.List;

/**
 * 商品管理Service接口
 * 
 * @author zhuangcy
 * @date 2020-05-14
 */
public interface IMallGoodsService 
{
    /**
     * 查询商品管理
     * 
     * @param goodsId 商品管理ID
     * @return 商品管理
     */
    public MallGoods selectMallGoodsById(Long goodsId);

    /**
     * 查询商品管理列表
     * 
     * @param mallGoods 商品管理
     * @return 商品管理集合
     */
    public List<MallGoods> selectMallGoodsList(MallGoods mallGoods);

    /**
     * 新增商品管理
     * 
     * @param mallGoods 商品管理
     * @return 结果
     */
    public int insertMallGoods(MallGoods mallGoods);

    /**
     * 修改商品管理
     * 
     * @param mallGoods 商品管理
     * @return 结果
     */
    public int updateMallGoods(MallGoods mallGoods);

    /**
     * 批量删除商品管理
     * 
     * @param goodsIds 需要删除的商品管理ID
     * @return 结果
     */
    public int deleteMallGoodsByIds(Long[] goodsIds);

    /**
     * 删除商品管理信息
     * 
     * @param goodsId 商品管理ID
     * @return 结果
     */
    public int deleteMallGoodsById(Long goodsId);

    /**
     * 批量修改商品状态
     * @param goodsIds
     * @param status
     * @return
     */
    int updateSelectMallGoods(Integer[] goodsIds,Integer status);

    /**
     * wei
     * @return
     */
    List<MallGoods> selectMallGoodsListByStatus();

}
