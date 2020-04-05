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
    private String productName;
    private String productImage;
    private BigDecimal productPrice;
}
