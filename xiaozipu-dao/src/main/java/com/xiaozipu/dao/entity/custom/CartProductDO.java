package com.xiaozipu.dao.entity.custom;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 20:14
 * @description:
 */
@Data
public class CartProductDO {
    /**
     * 购物车的id
     */
    private Integer cartId;
    /**
     * 商品规格id
     */
    private Integer productSpecId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品图片
     */
    private String productImageUrl;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 数量
     */
    private Integer quantity;
    private Integer stock;
}
