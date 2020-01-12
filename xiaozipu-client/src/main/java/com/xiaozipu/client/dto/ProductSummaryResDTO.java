package com.xiaozipu.client.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 11:56
 * @description:
 */
@Data
public class ProductSummaryResDTO {
    private String productName;
    private String productPictureUrl;
    private BigDecimal price;
}
