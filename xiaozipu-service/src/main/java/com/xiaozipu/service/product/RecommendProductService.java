package com.xiaozipu.service.product;

import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.service.domain.vo.ProductSummaryVO;

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
     * @param productIds
     */
    void insertRecommendProduct(List<Integer> productIds);
}
