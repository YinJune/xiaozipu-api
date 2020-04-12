package com.xiaozipu.merchant.dao.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/28 14:24
 * @description:
 */
@Data
public class OrderListDO {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 订单商品列表 里边的cartid为空
     */
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    private BigDecimal payAmount;
    /**
     * 订单商品的爽
     */
//    private Integer quantity;
    /**
     * 创建时间
     */
    private Date createTime;

    private List<OrderProductDTO> orderProducts;
}
