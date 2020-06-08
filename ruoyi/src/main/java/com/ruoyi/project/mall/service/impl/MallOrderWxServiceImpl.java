package com.ruoyi.project.mall.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mall.mapper.MallOrderWxMapper;
import com.ruoyi.project.mall.domain.MallOrderWx;
import com.ruoyi.project.mall.service.IMallOrderWxService;

/**
 * 微信订单总Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
@Service
public class MallOrderWxServiceImpl implements IMallOrderWxService 
{
    @Autowired
    private MallOrderWxMapper mallOrderWxMapper;

    /**
     * 查询微信订单总
     * 
     * @param wxOrderId 微信订单总ID
     * @return 微信订单总
     */
    @Override
    public MallOrderWx selectMallOrderWxById(Long wxOrderId)
    {
        return mallOrderWxMapper.selectMallOrderWxById(wxOrderId);
    }

    /**
     * 查询微信订单总列表
     * 
     * @param mallOrderWx 微信订单总
     * @return 微信订单总
     */
    @Override
    public List<MallOrderWx> selectMallOrderWxList(MallOrderWx mallOrderWx)
    {
        return mallOrderWxMapper.selectMallOrderWxList(mallOrderWx);
    }

    /**
     * 新增微信订单总
     * 
     * @param mallOrderWx 微信订单总
     * @return 结果
     */
    @Override
    public int insertMallOrderWx(MallOrderWx mallOrderWx)
    {
        mallOrderWx.setCreateTime(DateUtils.getNowDate());
        return mallOrderWxMapper.insertMallOrderWx(mallOrderWx);
    }

    /**
     * 修改微信订单总
     * 
     * @param mallOrderWx 微信订单总
     * @return 结果
     */
    @Override
    public int updateMallOrderWx(MallOrderWx mallOrderWx)
    {
        return mallOrderWxMapper.updateMallOrderWx(mallOrderWx);
    }

    /**
     * 批量删除微信订单总
     * 
     * @param wxOrderIds 需要删除的微信订单总ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderWxByIds(Long[] wxOrderIds)
    {
        return mallOrderWxMapper.deleteMallOrderWxByIds(wxOrderIds);
    }

    /**
     * 删除微信订单总信息
     * 
     * @param wxOrderId 微信订单总ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderWxById(Long wxOrderId)
    {
        return mallOrderWxMapper.deleteMallOrderWxById(wxOrderId);
    }
}
