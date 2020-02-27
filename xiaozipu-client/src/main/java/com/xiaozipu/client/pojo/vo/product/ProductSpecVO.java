package com.xiaozipu.client.pojo.vo.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/2/27 17:57
 * @description:
 */
@Data
public class ProductSpecVO {
    /**
     * 商品规格id
     */
    private Integer id;
    /**
     * 规格组合
     */
    private String spec;
    /**
     * 规格图片
     */
    private String specImageUrl;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 商品规格单价
     */
    private BigDecimal price;
}
