package com.ruoyi.project.mall.service;

import com.ruoyi.project.mall.domain.MallStore;

import java.util.List;

/**
 * 店铺Service接口
 * 
 * @author zhuangcy
 * @date 2020-06-02
 */
public interface IMallStoreService 
{
    /**
     * 查询店铺
     * 
     * @param storeId 店铺ID
     * @return 店铺
     */
    public MallStore selectMallStoreById(Long storeId);

    /**
     * 查询店铺列表
     * 
     * @param mallStore 店铺
     * @return 店铺集合
     */
    public List<MallStore> selectMallStoreList(MallStore mallStore);

    /**
     * 新增店铺
     * 
     * @param mallStore 店铺
     * @return 结果
     */
    public int insertMallStore(MallStore mallStore);

    /**
     * 修改店铺
     * 
     * @param mallStore 店铺
     * @return 结果
     */
    public int updateMallStore(MallStore mallStore);

    /**
     * 批量删除店铺
     * 
     * @param storeIds 需要删除的店铺ID
     * @return 结果
     */
    public int deleteMallStoreByIds(Long[] storeIds);

    /**
     * 删除店铺信息
     * 
     * @param storeId 店铺ID
     * @return 结果
     */
    public int deleteMallStoreById(Long storeId);

}
