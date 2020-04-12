package com.xiaozipu.merchant.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/4/5 19:14
 * @description:
 */
@Data
public class OrderProductDTO {
    private Integer productId;
    private Integer orderProductId;
    private String productName;
    private String productCode;
    private String productImage;
    private Integer quantity;
    private BigDecimal productPrice;
}
