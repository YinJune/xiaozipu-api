package com.xiaozipu.merchant.pojo.dto.product.recommend;

import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/14 11:31
 * @description:
 */
@Data
public class AddRecommendProductReqDTO {
    private List<Integer> productIds;
}
