package com.xiaozipu.client.pojo.dto;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 11:53
 * @description:
 */
@Data
public class AddCartDTO {
    /**
     * 商品规格id
     */
    private Integer productSpecId;
    /**
     * 商品数量
     */
    private Integer quantity;
}
