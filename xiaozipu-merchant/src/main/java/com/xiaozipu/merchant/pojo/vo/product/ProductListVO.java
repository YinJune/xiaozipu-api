package com.xiaozipu.merchant.pojo.vo.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/3/21 10:39
 * @description:
 */
@Data
public class ProductListVO {
    private Integer id;
    private String name;
    private String code;
    /**
     * 简介
     */
    private String summary;
    private BigDecimal productPrice;
    private String imageUrl;
    private String status;
}
