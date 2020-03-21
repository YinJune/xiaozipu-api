package com.xiaozipu.merchant.dao.mapper;

import com.xiaozipu.merchant.dao.entity.ProductListDO;
import com.xiaozipu.merchant.dao.entity.ProductSummaryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:28
 * @description:
 */
public interface ProductDao {
    /**
     * 商品列表
     * @param status
     * @return
     */
    List<ProductListDO> getProductList(@Param("status") String status);
    /**
     * 根据商品id查询商品简要信息
     *
     * @param productId
     * @return
     */
    ProductSummaryDO getProductSummaryById(@Param("productId") Integer productId);
}
