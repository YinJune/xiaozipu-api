package com.xiaozipu.client.service.product;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.client.enums.StatusEnum;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.entity.generator.TRecommendProduct;
import com.xiaozipu.dao.entity.generator.TRecommendProductExample;
import com.xiaozipu.dao.mapper.generator.TRecommendProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:16
 * @description:
 */
@Service
public class RecommendProductServiceImpl implements RecommendProductService {

    private static final Logger logger= LoggerFactory.getLogger(RecommendProductServiceImpl.class);

    @Resource
    private TRecommendProductMapper recommendProductMapper;
    @Autowired
    private ProductService productService;

    /**
     * 插入
     *
     * @param productIds
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertRecommendProduct(List<Integer> productIds) {
        List<TRecommendProduct> recommendProducts=new ArrayList<>();
        for (Integer productId:productIds){
            TRecommendProduct recommendProduct=new TRecommendProduct();
            recommendProduct.setProductId(productId);
            recommendProduct.setDeleted("2");
            recommendProduct.setStatus("1");
            recommendProducts.add(recommendProduct);
        }
        recommendProductMapper.batchInsert(recommendProducts);
    }

    /**
     * 查询推荐商品
     *
     * @param currentPage
     * @return
     */
    @Override
    public List<ProductSummaryDO> listRecommendProduct(Integer currentPage) {
        PageHelper.startPage(currentPage, 10);
        PageHelper.orderBy("");
        TRecommendProductExample recommendProductExample = new TRecommendProductExample();
        recommendProductExample.createCriteria().andStatusEqualTo(StatusEnum.VALID.getKey()).andDeletedEqualTo(StatusEnum.INVALID.getKey());

        List<TRecommendProduct> recommendProductList = recommendProductMapper.selectByExample(recommendProductExample);
        List<ProductSummaryDO> productSummaryDOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(recommendProductList)) {
            for (TRecommendProduct recommendProduct : recommendProductList) {
                ProductSummaryDO productSummaryDO = productService.getProductSummaryBoById(recommendProduct.getProductId());
                productSummaryDOList.add(productSummaryDO);
            }
        }
        return productSummaryDOList;
    }
}
