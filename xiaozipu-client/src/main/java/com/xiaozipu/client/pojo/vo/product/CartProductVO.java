package com.xiaozipu.client.pojo.vo.product;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 12:16
 * @description:
 */
@Data
public class CartProductVO extends ProductSummaryVO {
    /**
     * 购物车的id
     */
    private Integer id;
    /**
     * 商品规格id
     */
    private Integer productSpecId;
    /**
     * 数量
     */
    private Integer quantity;
}
