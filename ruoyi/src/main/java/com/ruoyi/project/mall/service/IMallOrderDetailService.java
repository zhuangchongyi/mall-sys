package com.ruoyi.project.mall.service;

import java.util.List;
import com.ruoyi.project.mall.domain.MallOrderDetail;

/**
 * 商品订单明细Service接口
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public interface IMallOrderDetailService 
{
    /**
     * 查询商品订单明细
     * 
     * @param orderDetailId 商品订单明细ID
     * @return 商品订单明细
     */
    public MallOrderDetail selectMallOrderDetailById(Long orderDetailId);

    /**
     * 查询商品订单明细列表
     * 
     * @param mallOrderDetail 商品订单明细
     * @return 商品订单明细集合
     */
    public List<MallOrderDetail> selectMallOrderDetailList(MallOrderDetail mallOrderDetail);

    /**
     * 新增商品订单明细
     * 
     * @param mallOrderDetail 商品订单明细
     * @return 结果
     */
    public int insertMallOrderDetail(MallOrderDetail mallOrderDetail);

    /**
     * 修改商品订单明细
     * 
     * @param mallOrderDetail 商品订单明细
     * @return 结果
     */
    public int updateMallOrderDetail(MallOrderDetail mallOrderDetail);

    /**
     * 批量删除商品订单明细
     * 
     * @param orderDetailIds 需要删除的商品订单明细ID
     * @return 结果
     */
    public int deleteMallOrderDetailByIds(Long[] orderDetailIds);

    /**
     * 删除商品订单明细信息
     * 
     * @param orderDetailId 商品订单明细ID
     * @return 结果
     */
    public int deleteMallOrderDetailById(Long orderDetailId);
}
