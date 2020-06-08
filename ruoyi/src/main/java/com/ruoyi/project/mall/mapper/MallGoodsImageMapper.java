package com.ruoyi.project.mall.mapper;

import com.ruoyi.project.mall.domain.MallGoodsImage;

import java.util.List;

/**
 * 商品图片Mapper接口
 * 
 * @author zhuangcy
 * @date 2020-05-19
 */
public interface MallGoodsImageMapper 
{
    /**
     * 查询商品图片
     * 
     * @param imageId 商品图片ID
     * @return 商品图片
     */
    public MallGoodsImage selectMallGoodsImageById(Long imageId);

    /**
     * 查询商品图片列表
     * 
     * @param mallGoodsImage 商品图片
     * @return 商品图片集合
     */
    public List<MallGoodsImage> selectMallGoodsImageList(MallGoodsImage mallGoodsImage);

    /**
     * 新增商品图片
     * 
     * @param mallGoodsImage 商品图片
     * @return 结果
     */
    public int insertMallGoodsImage(MallGoodsImage mallGoodsImage);

    /**
     * 修改商品图片
     * 
     * @param mallGoodsImage 商品图片
     * @return 结果
     */
    public int updateMallGoodsImage(MallGoodsImage mallGoodsImage);

    /**
     * 删除商品图片
     * 
     * @param imageId 商品图片ID
     * @return 结果
     */
    public int deleteMallGoodsImageById(Long imageId);

    /**
     * 批量删除商品图片
     * 
     * @param imageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallGoodsImageByIds(Long[] imageIds);

    /**
     * 根据商品id查询图片
     * @param goodsId
     * @return
     */
    List<MallGoodsImage> findGoodsImageByGoodsId(Long goodsId);
}
