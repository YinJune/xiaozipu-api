package com.xiaozipu.dao.entity.custom;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/3/2 21:28
 * @description:
 */
@Data
public class OrderDetailDO {
    /**
     * 支付方式
     */
    private String payType;
    /**
     * 实付款
     */
    private BigDecimal payAmount;
}
