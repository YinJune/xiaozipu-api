package com.xiaozipu.service.product;

import com.xiaozipu.service.pojo.dto.product.AddProductSpecReqDTO;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:19
 * @description:
 */
public interface ProductSpecService {
    /**
     * 添加商品规格
     * @param addProductSpecReqDTOS
     */
    void addProductSpec(List<AddProductSpecReqDTO> addProductSpecReqDTOS);
}
