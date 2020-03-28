package com.xiaozipu.merchant.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/3/21 12:50
 * @description:
 */
@Data
public class ProductListDO {
    private Integer id;
    private String name;
    private String code;
    /**
     * 简介
     */
    private String summary;
    private BigDecimal price;
    private BigDecimal lineationPrice;
    private String imageUrl;
    private String status;
}
