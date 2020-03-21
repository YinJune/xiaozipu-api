package com.xiaozipu.client.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:37
 * @description:
 */
@Data
public class ProductSummaryDO {
    private Integer productId;
    private String productName;
    private String productImageUrl;
    private BigDecimal productPrice;
    private BigDecimal lineationPrice;
    /**
     * 商品简介
     */
    private String summary;
}
