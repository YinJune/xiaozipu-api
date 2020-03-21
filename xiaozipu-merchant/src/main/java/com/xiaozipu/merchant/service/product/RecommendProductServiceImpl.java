package com.xiaozipu.merchant.service.product;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.dao.entity.TRecommendProduct;
import com.xiaozipu.dao.entity.TRecommendProductExample;
import com.xiaozipu.dao.mapper.TRecommendProductMapper;
import com.xiaozipu.merchant.dao.entity.ProductSummaryDO;
import com.xiaozipu.merchant.pojo.dto.product.recommend.AddRecommendProductReqDTO;
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

    private static final Logger logger = LoggerFactory.getLogger(RecommendProductServiceImpl.class);

    @Resource
    private TRecommendProductMapper recommendProductMapper;
    @Autowired
    private ProductService productService;

    /**
     * 插入
     *
     * @param addRecommendProductReqDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertRecommendProduct(AddRecommendProductReqDTO addRecommendProductReqDTO) {
        List<TRecommendProduct> recommendProducts = new ArrayList<>();
        for (Integer productId : addRecommendProductReqDTO.getProductIds()) {
            TRecommendProduct recommendProduct = new TRecommendProduct();
            recommendProduct.setProductId(productId);
            recommendProduct.setDeleted(StatusEnum.INVALID.getKey());
            recommendProduct.setStatus(StatusEnum.VALID.getKey());
            recommendProducts.add(recommendProduct);
        }
        //insert 无需指定selective
        recommendProductMapper.batchInsertSelective(recommendProducts, TRecommendProduct.Column.productId, TRecommendProduct.Column.deleted, TRecommendProduct.Column.status);
    }

    /**
     * 查询推荐商品
     *
     * @param currentPage
     * @return
     */
    @Override
    public List<ProductSummaryDO> listRecommendProduct(Integer currentPage) {
        PageHelper.startPage(currentPage, 20);
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
