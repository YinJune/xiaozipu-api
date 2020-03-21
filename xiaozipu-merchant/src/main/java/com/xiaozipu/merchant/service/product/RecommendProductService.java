package com.xiaozipu.merchant.service.product;

import com.xiaozipu.merchant.dao.entity.ProductSummaryDO;
import com.xiaozipu.merchant.pojo.dto.product.recommend.AddRecommendProductReqDTO;

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
    List<ProductSummaryDO> listRecommendProduct(Integer currentPage);

    /**
     * 插入
     *
     * @param addRecommendProductReqDTO
     */
    void insertRecommendProduct(AddRecommendProductReqDTO addRecommendProductReqDTO);
}
