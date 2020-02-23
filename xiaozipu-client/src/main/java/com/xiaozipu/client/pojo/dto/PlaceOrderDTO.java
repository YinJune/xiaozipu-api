package com.xiaozipu.client.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 14:26
 * @description:
 */
@Data
public class PlaceOrderDTO {
    /**
     * 商品规格id
     */
    private List<Integer> productSpecIds;
    /**
     * 地址id
     */
    private Integer addressId;
}
