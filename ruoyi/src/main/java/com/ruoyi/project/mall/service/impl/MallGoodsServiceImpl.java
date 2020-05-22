package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.mall.domain.MallGoods;
import com.ruoyi.project.mall.mapper.MallGoodsMapper;
import com.ruoyi.project.mall.service.IMallGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品管理Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-05-14
 */
@Service
public class MallGoodsServiceImpl implements IMallGoodsService 
{
    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    /**
     * 查询商品管理
     * 
     * @param goodsId 商品管理ID
     * @return 商品管理
     */
    @Override
    public MallGoods selectMallGoodsById(Long goodsId)
    {
        return mallGoodsMapper.selectMallGoodsById(goodsId);
    }

    /**
     * 查询商品管理列表
     * 
     * @param mallGoods 商品管理
     * @return 商品管理
     */
    @Override
    public List<MallGoods> selectMallGoodsList(MallGoods mallGoods)
    {
        return mallGoodsMapper.selectMallGoodsList(mallGoods);
    }

    /**
     * 新增商品管理
     * 
     * @param mallGoods 商品管理
     * @return 结果
     */
    @Override
    public int insertMallGoods(MallGoods mallGoods)
    {
        mallGoods.setCreateBy(SecurityUtils.getUsername());
        mallGoods.setCreateDate(DateUtils.getNowDate());
        return mallGoodsMapper.insertMallGoods(mallGoods);
    }

    /**
     * 修改商品管理
     * 
     * @param mallGoods 商品管理
     * @return 结果
     */
    @Override
    public int updateMallGoods(MallGoods mallGoods)
    {
        mallGoods.setUpdateBy(SecurityUtils.getUsername());
        mallGoods.setUpdateTime(new Date());
        return mallGoodsMapper.updateMallGoods(mallGoods);
    }

    /**
     * 批量删除商品管理
     * 
     * @param goodsIds 需要删除的商品管理ID
     * @return 结果
     */
    @Override
    public int deleteMallGoodsByIds(Long[] goodsIds)
    {
        return mallGoodsMapper.deleteMallGoodsByIds(goodsIds);
    }

    /**
     * 删除商品管理信息
     * 
     * @param goodsId 商品管理ID
     * @return 结果
     */
    @Override
    public int deleteMallGoodsById(Long goodsId)
    {
        return mallGoodsMapper.deleteMallGoodsById(goodsId);
    }

    /**
     * 批量修改商品状态
     * @param goodsIds
     * @param status
     * @return
     */
    @Override
    public int updateSelectMallGoods(Integer[] goodsIds, Integer status) {
        return mallGoodsMapper.updateSelectMallGoodsStatus(goodsIds,status);
    }

    @Override
    public List<MallGoods> selectMallGoodsListByStatus() {
        return mallGoodsMapper.selectMallGoodsListByStatus();
    }
}
