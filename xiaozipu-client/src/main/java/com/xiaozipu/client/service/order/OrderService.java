package com.xiaozipu.client.service.order;

import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;
import com.xiaozipu.dao.entity.custom.OrderListDO;

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
    Integer placeOrder(Integer userId, PlaceOrderDTO placeOrderDTO);

    /**
     * 订单列表
     *
     * @param userId
     * @param status
     * @param currentPage
     * @return
     */
    List<OrderListDO> getOrderList(Integer userId, String status, Integer currentPage);
}
