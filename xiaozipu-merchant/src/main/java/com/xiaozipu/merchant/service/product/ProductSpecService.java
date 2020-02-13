package com.xiaozipu.merchant.service.product;


import com.xiaozipu.merchant.pojo.dto.product.AddProductSpecReqDTO;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:19
 * @description:
 */
public interface ProductSpecService {
    /**
     * 添加商品规格
     *
     * @param addProductSpecReqDTOS
     */
    void addProductSpec(AddProductSpecReqDTO addProductSpecReqDTOS);
}
