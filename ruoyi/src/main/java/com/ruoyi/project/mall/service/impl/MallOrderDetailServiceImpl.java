package com.ruoyi.project.mall.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.mall.domain.MallOrderDetail;
import com.ruoyi.project.mall.mapper.MallOrderDetailMapper;
import com.ruoyi.project.mall.service.IMallOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品订单明细Service业务层处理
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
@Service
public class MallOrderDetailServiceImpl implements IMallOrderDetailService 
{
    @Autowired
    private MallOrderDetailMapper mallOrderDetailMapper;

    /**
     * 查询商品订单明细
     * 
     * @param orderDetailId 商品订单明细ID
     * @return 商品订单明细
     */
    @Override
    public MallOrderDetail selectMallOrderDetailById(Long orderDetailId)
    {
        return mallOrderDetailMapper.selectMallOrderDetailById(orderDetailId);
    }

    /**
     * 查询商品订单明细列表
     * 
     * @param mallOrderDetail 商品订单明细
     * @return 商品订单明细
     */
    @Override
    public List<MallOrderDetail> selectMallOrderDetailList(MallOrderDetail mallOrderDetail)
    {
        return mallOrderDetailMapper.selectMallOrderDetailList(mallOrderDetail);
    }

    /**
     * 新增商品订单明细
     * 
     * @param mallOrderDetail 商品订单明细
     * @return 结果
     */
    @Override
    public int insertMallOrderDetail(MallOrderDetail mallOrderDetail)
    {
        mallOrderDetail.setCreateTime(DateUtils.getNowDate());
        return mallOrderDetailMapper.insertMallOrderDetail(mallOrderDetail);
    }

    /**
     * 修改商品订单明细
     * 
     * @param mallOrderDetail 商品订单明细
     * @return 结果
     */
    @Override
    public int updateMallOrderDetail(MallOrderDetail mallOrderDetail)
    {
        return mallOrderDetailMapper.updateMallOrderDetail(mallOrderDetail);
    }

    /**
     * 批量删除商品订单明细
     * 
     * @param orderDetailIds 需要删除的商品订单明细ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderDetailByIds(Long[] orderDetailIds)
    {
        return mallOrderDetailMapper.deleteMallOrderDetailByIds(orderDetailIds);
    }

    /**
     * 删除商品订单明细信息
     * 
     * @param orderDetailId 商品订单明细ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderDetailById(Long orderDetailId)
    {
        return mallOrderDetailMapper.deleteMallOrderDetailById(orderDetailId);
    }
}
