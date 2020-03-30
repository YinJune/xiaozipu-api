package com.xiaozipu.client.service.payment;

import com.xiaozipu.client.pojo.dto.mp.PaymentNotifyResDTO;
import com.xiaozipu.client.pojo.dto.mp.UnifiedOrderResDTO;
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
    UnifiedOrderResDTO unifiedOrder(TOrder order);

    /**
     * 微信支付回调
     * @param paymentNotifyResDTO
     */
    void payCallback(PaymentNotifyResDTO paymentNotifyResDTO);
}
