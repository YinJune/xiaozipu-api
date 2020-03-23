package com.xiaozipu.merchant.service.product;


import com.xiaozipu.dao.entity.TProductSpec;
import com.xiaozipu.merchant.pojo.dto.product.AddProductSpecReqDTO;

import java.util.List;

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

    /**
     * 根据商品id查规格
     *
     * @param id
     * @return
     */
    List<TProductSpec> getProductSpecsByProductId(Integer id);
}
