package com.xiaozipu.client.service.product;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.common.enums.product.SortTypeEnum;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.mapper.custom.ProductDao;
import com.xiaozipu.dao.mapper.generator.TProductImageMapper;
import com.xiaozipu.dao.mapper.generator.TProductMapper;
import com.xiaozipu.dao.mapper.generator.TProductSpecsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 12:11
 * @description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private TProductMapper productMapper;
    @Resource
    private ProductDao productDao;
    @Resource
    private TProductSpecsMapper specsMapper;
    @Resource
    private TProductImageMapper productImageMapper;

    /**
     * 根据商品id查询商品简要信息
     *
     * @param productId
     * @return
     */
    @Override
    public ProductSummaryDO getProductSummaryBoById(Integer productId) {
        return productDao.getProductSummaryById(productId);
    }


    /**
     * 商品列表
     *
     * @param currentPage
     * @param sortType
     * @return
     */
    @Override
    public List<ProductSummaryDO> getProductList(Integer currentPage, String sortType, String orderType) {
        PageHelper.startPage(currentPage, 10);
        List<ProductSummaryDO> productSummaryDOList = null;
        SortTypeEnum sortTypeEnum = SortTypeEnum.getEnumByType(sortType);
        if (sortTypeEnum.getColumn().equals("volume")) {
            //TODO 销量 查订单
            productSummaryDOList = productDao.getProductList("create_time");
        } else {
            productSummaryDOList = productDao.getProductList(sortTypeEnum.getColumn());
        }

        return productSummaryDOList;
    }
}
