package com.xiaozipu.client.service.payment;

import com.xiaozipu.client.pojo.dto.mp.PaymentNotifyResDTO;
import com.xiaozipu.client.service.wechat.WeChatPayService;
import com.xiaozipu.dao.entity.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: YinJunJie
 * @date: 2020/2/24 20:51
 * @description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private WeChatPayService weChatPayService;

    /**
     * 统一下单
     *
     * @param order
     */
    @Override
    public void unifiedOrder(TOrder order) {
        weChatPayService.unifiedOrder(order);
    }

    /**
     * 微信支付回调
     *
     * @param paymentNotifyResDTO
     */
    @Override
    public void payCallback(PaymentNotifyResDTO paymentNotifyResDTO) {

    }
}
