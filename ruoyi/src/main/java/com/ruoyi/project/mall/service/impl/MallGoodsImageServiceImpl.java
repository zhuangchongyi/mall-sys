package com.ruoyi.project.mall.service.impl;

import com.ruoyi.project.mall.domain.MallGoodsImage;
import com.ruoyi.project.mall.mapper.MallGoodsImageMapper;
import com.ruoyi.project.mall.service.IMallGoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品图片Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-05-19
 */
@Service
public class MallGoodsImageServiceImpl implements IMallGoodsImageService 
{
    @Autowired
    private MallGoodsImageMapper mallGoodsImageMapper;

    /**
     * 查询商品图片
     * 
     * @param imageId 商品图片ID
     * @return 商品图片
     */
    @Override
    public MallGoodsImage selectMallGoodsImageById(Long imageId)
    {
        return mallGoodsImageMapper.selectMallGoodsImageById(imageId);
    }

    /**
     * 查询商品图片列表
     * 
     * @param mallGoodsImage 商品图片
     * @return 商品图片
     */
    @Override
    public List<MallGoodsImage> selectMallGoodsImageList(MallGoodsImage mallGoodsImage)
    {
        return mallGoodsImageMapper.selectMallGoodsImageList(mallGoodsImage);
    }

    /**
     * 新增商品图片
     * 
     * @param mallGoodsImage 商品图片
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMallGoodsImage(MallGoodsImage mallGoodsImage)
    {
        return mallGoodsImageMapper.insertMallGoodsImage(mallGoodsImage);
    }

    /**
     * 修改商品图片
     * 
     * @param mallGoodsImage 商品图片
     * @return 结果
     */
    @Override
    public int updateMallGoodsImage(MallGoodsImage mallGoodsImage)
    {
        return mallGoodsImageMapper.updateMallGoodsImage(mallGoodsImage);
    }

    /**
     * 批量删除商品图片
     * 
     * @param imageIds 需要删除的商品图片ID
     * @return 结果
     */
    @Override
    public int deleteMallGoodsImageByIds(Long[] imageIds)
    {
        return mallGoodsImageMapper.deleteMallGoodsImageByIds(imageIds);
    }

    /**
     * 删除商品图片信息
     * 
     * @param imageId 商品图片ID
     * @return 结果
     */
    @Override
    public int deleteMallGoodsImageById(Long imageId)
    {
        return mallGoodsImageMapper.deleteMallGoodsImageById(imageId);
    }

    @Override
    public List<MallGoodsImage> findGoodsImageByGoodsId(Long goodsId) {
        return mallGoodsImageMapper.findGoodsImageByGoodsId(goodsId);
    }
}
