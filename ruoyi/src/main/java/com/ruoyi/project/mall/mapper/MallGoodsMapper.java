package com.ruoyi.project.mall.mapper;

import com.ruoyi.project.mall.domain.MallGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品管理Mapper接口
 * 
 * @author zhuangcy
 * @date 2020-05-14
 */
public interface MallGoodsMapper 
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
     * 删除商品管理
     * 
     * @param goodsId 商品管理ID
     * @return 结果
     */
    public int deleteMallGoodsById(Long goodsId);

    /**
     * 批量删除商品管理
     * 
     * @param goodsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallGoodsByIds(Long[] goodsIds);

    /**
     * 批量修改商品状态
     * @param goodsIds
     * @param status
     * @return
     */
    int updateSelectMallGoodsStatus(@Param("goodsIds") Integer[] goodsIds,@Param("status") Integer status);

    /**
     * 微信端查询商品列表
     * @return
     */
    List<MallGoods> selectMallGoodsListByStatus();
}
