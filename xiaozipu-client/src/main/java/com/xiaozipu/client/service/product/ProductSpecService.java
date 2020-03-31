package com.xiaozipu.client.service.product;

import com.xiaozipu.dao.entity.TProductSpec;

import java.math.BigDecimal;
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
    List<TProductSpec> getSpecsByProductId(Integer productId);

    /**
     * 计算商品集合金额
     *
     * @param productSpecId
     * @return
     */
    BigDecimal calculateAmount(Integer productSpecId, Integer quantity);

    /**
     * 获取商品规格byid
     *
     * @param productSpecId
     * @return
     */
    TProductSpec getById(Integer productSpecId);

    /**
     * 批量查询商品规格根据id
     *
     * @param productSpecIds
     * @return
     */
    List<TProductSpec> listProductSpec(List<Integer> productSpecIds);

    /**
     * 更新商品规格
     *
     * @param productSpec
     */
    void updateProductSpec(TProductSpec productSpec);

    /**
     * 批量更新商品规格
     *
     * @param productSpecs
     */
    void batchUpdateProductSpec(List<TProductSpec> productSpecs);
}
