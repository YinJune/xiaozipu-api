package com.xiaozipu.client.pojo.dto.order;

import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/24 20:28
 * @description: 确认订单页信息获取 dto
 */
@Data
public class CalculateAmountDTO {
    /**
     * 商品规格id 从商品详情也来的时候用这个  进下单页面时 不会有多个商品
     */
    private List<ProductSpecQuantity> productSpecQuantityList;
    /**
     * 从购物车来的时候用这个  进下单页面时会有多个商品
     */
    private List<Integer> cartIds;
}
