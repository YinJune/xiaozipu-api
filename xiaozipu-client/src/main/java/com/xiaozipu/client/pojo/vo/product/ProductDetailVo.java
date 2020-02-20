package com.xiaozipu.client.pojo.vo.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/20 17:59
 * @description:
 */
@Data
public class ProductDetailVo {
    private Integer productId;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品图片
     */
    private List<ProductImageVo> productImageVos;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 划线价
     */
    private BigDecimal lineationPrice;
    /**
     * 商品简介
     */
    private String summary;
    /**
     * 商品规格
     */
    private List<ProductSpecVo> productSpecVos;
}
