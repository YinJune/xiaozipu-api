package com.xiaozipu.client.pojo.dto.order;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 16:39
 * @description:
 */
@Data
public class PlaceOrderDTO extends CalculateAmountDTO {
    /**
     * 商品规格和数量
     */
//    private List<ProductSpecQuantity> productSpecQuantityList;
    /**
     * 地址id
     */
    private Integer addressId;
}
