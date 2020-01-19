package com.xiaozipu.service.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 12:23
 * @description:
 */
@Data
public class ProductSummaryVO {
    private Integer productId;
    private String productName;
    private String productImageUrl;
    private BigDecimal productPrice;
    private BigDecimal lineationPrice;
}
