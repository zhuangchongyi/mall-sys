package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.mall.domain.MallStore;
import com.ruoyi.project.mall.mapper.MallStoreMapper;
import com.ruoyi.project.mall.service.IMallStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 店铺Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-06-02
 */
@Service
public class MallStoreServiceImpl implements IMallStoreService 
{
    @Autowired
    private MallStoreMapper mallStoreMapper;

    /**
     * 查询店铺
     * 
     * @param storeId 店铺ID
     * @return 店铺
     */
    @Override
    public MallStore selectMallStoreById(Long storeId)
    {
        return mallStoreMapper.selectMallStoreById(storeId);
    }

    /**
     * 查询店铺列表
     * 
     * @param mallStore 店铺
     * @return 店铺
     */
    @Override
    public List<MallStore> selectMallStoreList(MallStore mallStore)
    {
        return mallStoreMapper.selectMallStoreList(mallStore);
    }

    /**
     * 新增店铺
     * 
     * @param mallStore 店铺
     * @return 结果
     */
    @Override
    public int insertMallStore(MallStore mallStore)
    {
        mallStore.setCreateTime(DateUtils.getNowDate());
        return mallStoreMapper.insertMallStore(mallStore);
    }

    /**
     * 修改店铺
     * 
     * @param mallStore 店铺
     * @return 结果
     */
    @Override
    public int updateMallStore(MallStore mallStore)
    {
        mallStore.setUpdateTime(DateUtils.getNowDate());
        return mallStoreMapper.updateMallStore(mallStore);
    }

    /**
     * 批量删除店铺
     * 
     * @param storeIds 需要删除的店铺ID
     * @return 结果
     */
    @Override
    public int deleteMallStoreByIds(Long[] storeIds)
    {
        return mallStoreMapper.deleteMallStoreByIds(storeIds);
    }

    /**
     * 删除店铺信息
     * 
     * @param storeId 店铺ID
     * @return 结果
     */
    @Override
    public int deleteMallStoreById(Long storeId)
    {
        return mallStoreMapper.deleteMallStoreById(storeId);
    }

}
