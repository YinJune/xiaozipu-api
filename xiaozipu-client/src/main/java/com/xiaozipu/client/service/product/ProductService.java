package com.xiaozipu.client.service.product;

import com.xiaozipu.client.pojo.vo.product.ProductDetailVO;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;

import java.util.List;

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
    ProductSummaryDO getProductSummaryBoById(Integer productId);

    /**
     * 商品列表
     *
     * @param currentPage
     * @param sortType
     * @return
     */
    List<ProductSummaryDO> getProductList(Integer currentPage, String sortType, String orderType, Integer categoryId);

    /**
     * 查询商品详情
     *
     * @param productId
     */
    ProductDetailVO getProductDetail(Integer productId);
}
