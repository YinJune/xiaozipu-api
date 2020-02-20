package com.xiaozipu.client.service.product;

import com.xiaozipu.dao.entity.generator.TProductSpecs;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:19
 * @description:
 */
public interface ProductSpecService {

    /**
     * 根据商品id查询商品属性
     *
     * @param productId
     * @return
     */
    List<TProductSpecs> findSpecByProductId(Integer productId);
}
