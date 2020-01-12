package com.xiaozipu.dao.mapper.custom;

import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:28
 * @description:
 */
public interface ProductDao {
    /**
     * 根据商品id查询商品简要信息
     *
     * @param productId
     * @return
     */
    ProductSummaryDO getProductSummaryById(@Param("productId") Integer productId);
}
