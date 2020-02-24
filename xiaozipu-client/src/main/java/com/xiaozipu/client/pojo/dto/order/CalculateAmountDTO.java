package com.xiaozipu.client.pojo.dto.order;

import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/24 20:28
 * @description:
 */
@Data
public class CalculateAmountDTO {
    /**
     * 商品规格id
     */
    private List<Integer> productSpecIds;
}
