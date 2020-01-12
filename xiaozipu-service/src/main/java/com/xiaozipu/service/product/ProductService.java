package com.xiaozipu.service.product;

import com.xiaozipu.service.bo.ProductSummaryBO;

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
    ProductSummaryBO getProductSummaryBoById(Integer productId);
}
