package com.xiaozipu.client.pojo.vo.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/3/2 21:06
 * @description:
 */
@Data
public class OrderDetailVO extends OrderListVO {
    /**
     * 支付方式
     */
    private String payType;
    /**
     * 实付款
     */
    private BigDecimal payAmount;
    /**
     * 地址信息
     */
    private String recipientName;
    private String recipientMobile;
    private String addressDetail;
}
