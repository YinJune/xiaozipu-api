package com.xiaozipu.service.product;

import com.xiaozipu.service.bo.ProductSummaryBO;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:16
 * @description:
 */
public interface RecommendProductService {
    /**
     * 查询推荐商品
     *
     * @param currentPage
     * @return
     */
    List<ProductSummaryBO> listRecommendProduct(Integer currentPage);

    /**
     * 插入
     * @param productIds
     */
    void insertRecommendProduct(List<Integer> productIds);
}
