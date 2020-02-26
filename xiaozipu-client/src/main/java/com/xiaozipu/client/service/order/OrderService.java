package com.xiaozipu.client.service.order;

import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;

import java.math.BigDecimal;

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
}
