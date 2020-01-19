package com.xiaozipu.service.product;

import com.xiaozipu.dao.entity.custom.ProductSummaryDO;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 12:11
 * @description:
 */
public interface ProductService {
    /**
     * 根据商品id查询商品简要信息
     *
     * @param productId
     * @return
     */
    ProductSummaryDO getProductSummaryBoById(Integer productId);

    /**
     * 排行榜
     *
     * @param type
     * @return
     */
    List<ProductSummaryDO> getRankingList(Integer currentPage, String type);
}
