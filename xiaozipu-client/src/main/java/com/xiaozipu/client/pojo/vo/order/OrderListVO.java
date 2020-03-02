package com.xiaozipu.client.pojo.vo.order;

import com.xiaozipu.client.pojo.vo.product.CartProductVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/3/2 20:40
 * @description:
 */
@Data
public class OrderListVO {
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
    private List<CartProductVO> products;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单商品的爽
     */
    private Integer quantity;
    /**
     * 创建时间
     */
    private Date createTime;
}
