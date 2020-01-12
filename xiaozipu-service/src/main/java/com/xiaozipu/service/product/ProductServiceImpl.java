package com.xiaozipu.service.product;

import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.mapper.custom.ProductDao;
import com.xiaozipu.dao.mapper.generator.TProductMapper;
import com.xiaozipu.service.bo.ProductSummaryBO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    /**
     * 根据商品id查询商品简要信息
     *
     * @param productId
     * @return
     */
    @Override
    public ProductSummaryBO getProductSummaryBoById(Integer productId) {
        ProductSummaryDO productSummaryDO=productDao.getProductSummaryById(productId);
        ProductSummaryBO productSummaryBO=new ProductSummaryBO();
        if (productSummaryDO!=null){
            BeanUtils.copyProperties(productSummaryDO,productSummaryBO);
        }
        return productSummaryBO;
    }
}
