package com.ruoyi.project.mall.mapper;

import com.ruoyi.project.mall.domain.MallOrderDetail;

import java.util.List;

/**
 * 商品订单明细Mapper接口
 * 
 * @author zhuangcy
 * @date 2020-06-06
 */
public interface MallOrderDetailMapper 
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
     * 删除商品订单明细
     * 
     * @param orderDetailId 商品订单明细ID
     * @return 结果
     */
    public int deleteMallOrderDetailById(Long orderDetailId);

    /**
     * 批量删除商品订单明细
     * 
     * @param orderDetailIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallOrderDetailByIds(Long[] orderDetailIds);

    /**
     * 根据订单号查询用户订单明细
     * @param orderNum
     * @return
     */
    List<MallOrderDetail> findUserOrderDetailsByOrderNum(String orderNum);
}
