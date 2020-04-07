package com.xiaozipu.client.service.payment;

import com.xiaozipu.client.pojo.dto.mp.PaymentNotifyResDTO;
import com.xiaozipu.client.pojo.vo.UnifiedOrderResVO;
import com.xiaozipu.client.service.order.OrderService;
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
    @Autowired
    private OrderService orderService;

    /**
     * 统一下单
     *
     * @param order
     */
    @Override
    public UnifiedOrderResVO unifiedOrder(TOrder order) throws Exception {
        UnifiedOrderResVO unifiedOrderResVO=weChatPayService.unifiedOrder(order);
        return unifiedOrderResVO;
    }

    /**
     * 微信支付回调
     *
     * @param paymentNotifyResDTO
     */
    @Override
    public void payCallback(PaymentNotifyResDTO paymentNotifyResDTO) {
        String orderCode=paymentNotifyResDTO.getOut_trade_no();
        orderService.paySuccess(orderCode);
    }
}
