package com.xiaozipu.client.service.payment;

import com.xiaozipu.dao.entity.TOrder;

/**
 * @author: YinJunJie
 * @date: 2020/2/24 20:50
 * @description:
 */
public interface PaymentService {
    /**
     * 统一下单
     *
     * @param order
     */
    void unifiedOrder(TOrder order);
}
