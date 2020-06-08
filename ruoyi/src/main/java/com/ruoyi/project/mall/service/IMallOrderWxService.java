package com.ruoyi.project.mall.service;

import java.util.List;
import com.ruoyi.project.mall.domain.MallOrderWx;

/**
 * 微信订单总Service接口
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public interface IMallOrderWxService 
{
    /**
     * 查询微信订单总
     * 
     * @param wxOrderId 微信订单总ID
     * @return 微信订单总
     */
    public MallOrderWx selectMallOrderWxById(Long wxOrderId);

    /**
     * 查询微信订单总列表
     * 
     * @param mallOrderWx 微信订单总
     * @return 微信订单总集合
     */
    public List<MallOrderWx> selectMallOrderWxList(MallOrderWx mallOrderWx);

    /**
     * 新增微信订单总
     * 
     * @param mallOrderWx 微信订单总
     * @return 结果
     */
    public int insertMallOrderWx(MallOrderWx mallOrderWx);

    /**
     * 修改微信订单总
     * 
     * @param mallOrderWx 微信订单总
     * @return 结果
     */
    public int updateMallOrderWx(MallOrderWx mallOrderWx);

    /**
     * 批量删除微信订单总
     * 
     * @param wxOrderIds 需要删除的微信订单总ID
     * @return 结果
     */
    public int deleteMallOrderWxByIds(Long[] wxOrderIds);

    /**
     * 删除微信订单总信息
     * 
     * @param wxOrderId 微信订单总ID
     * @return 结果
     */
    public int deleteMallOrderWxById(Long wxOrderId);
}
