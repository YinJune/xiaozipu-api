package com.xiaozipu.client.service.order;

import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;
import com.xiaozipu.client.dao.entity.OrderDetailDO;
import com.xiaozipu.client.dao.entity.OrderListDO;
import com.xiaozipu.client.pojo.vo.UnifiedOrderResVO;
import com.xiaozipu.client.pojo.vo.order.ConfirmOrderInfoVO;
import com.xiaozipu.dao.entity.TOrder;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 14:25
 * @description:
 */
public interface OrderService {
    /**
     * 计算金额
     *
     * @param calculateAmountDTO
     * @return
     */
    BigDecimal calculateAmount(CalculateAmountDTO calculateAmountDTO);

    /**
     * 下单
     *
     * @param placeOrderDTO
     * @return
     */
    UnifiedOrderResVO placeOrder(Integer userId, PlaceOrderDTO placeOrderDTO) throws Exception;

    /**
     * 订单列表
     *
     * @param userId
     * @param status
     * @param currentPage
     * @return
     */
    List<OrderListDO> getOrderList(Integer userId, String status, Integer currentPage);

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    OrderDetailDO getOrderDetail(Integer orderId);

    /**
     * 确认订单页信息
     *
     * @param calculateAmountDTO
     * @return
     */
    ConfirmOrderInfoVO confirmOrderInfo(Integer userId, CalculateAmountDTO calculateAmountDTO);

    /**
     * 根据code查询订单
     *
     * @param orderCode
     * @return
     */
    TOrder getOrderByCode(String orderCode);

    /**
     * 支付成功
     *
     * @param orderCode
     */
    void paySuccess(String orderCode);
}
