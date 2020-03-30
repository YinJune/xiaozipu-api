package com.xiaozipu.client.service.product;

import com.xiaozipu.client.pojo.dto.order.ProductSpecQuantity;
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
    BigDecimal calculateAmount(Integer productSpecId,Integer quantity);

    /**
     * 获取商品规格byid
     *
     * @param productSpecId
     * @return
     */
    TProductSpec getById(Integer productSpecId);
}
