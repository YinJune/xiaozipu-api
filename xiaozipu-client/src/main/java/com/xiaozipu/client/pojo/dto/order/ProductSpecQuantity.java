package com.xiaozipu.client.pojo.dto.order;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 18:05
 * @description:
 */
@Data
public class ProductSpecQuantity {
    /**
     * 商品规格id
     */
    private Integer productSpecId;
    /**
     * 该规格商品要买多少个 数量
     */
    private Integer quantity;
}
