package com.xiaozipu.service.pojo.dto.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:20
 * @description: 添加商品时候的 货品 sku
 */
@Data
public class AddProductSpecReqDTO {
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 规格组合
     */
    private String specs;
    /**
     * 该组合规格售价
     */
    private BigDecimal price;
    /**
     * 该规格成本价
     */
    private BigDecimal costPrice;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 规格图片
     */
    private String specImageUrl;
}
