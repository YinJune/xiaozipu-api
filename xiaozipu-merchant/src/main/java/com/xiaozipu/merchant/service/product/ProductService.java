package com.xiaozipu.merchant.service.product;

import com.xiaozipu.merchant.pojo.dto.product.AddProductReqDTO;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 12:11
 * @description:
 */
public interface ProductService {
    /**
     * 添加商品
     *
     * @param addProductReqDto
     */
    Integer addProduct(AddProductReqDTO addProductReqDto);

    /**
     * 更新商品状态
     *
     * @param productId
     * @param status
     */
    void updateProductStatus(Integer productId, String status);
}
