package com.xiaozipu.client.service.product;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.client.pojo.vo.product.*;
import com.xiaozipu.client.service.spec.SpecService;
import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.enums.product.SortTypeEnum;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.entity.generator.*;
import com.xiaozipu.dao.mapper.custom.ProductDao;
import com.xiaozipu.dao.mapper.generator.TProductImageMapper;
import com.xiaozipu.dao.mapper.generator.TProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Autowired
    private SpecService specService;
    @Resource
    private TProductImageMapper productImageMapper;
    @Autowired
    private ProductSpecService productSpecService;

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
     * @param orderType   asc desc
     * @return
     */
    @Override
    public List<ProductSummaryDO> getProductList(Integer currentPage, String sortType, String orderType, Integer categoryId) {
        PageHelper.startPage(currentPage, 10);
        List<ProductSummaryDO> productSummaryDOList = null;
        SortTypeEnum sortTypeEnum = SortTypeEnum.getEnumByType(sortType);
        if (sortTypeEnum.getColumn().equals("volume")) {
            //TODO 销量 查订单
            productSummaryDOList = productDao.getProductList(categoryId);
        } else {
            PageHelper.orderBy("p." + sortTypeEnum.getColumn() + " " + orderType);
            productSummaryDOList = productDao.getProductList(categoryId);
        }

        return productSummaryDOList;
    }

    /**
     * 查询商品详情
     *
     * @param productId
     */
    @Override
    public ProductDetailVO getProductDetail(Integer productId) {
        ProductDetailVO productDetailVo = new ProductDetailVO();
        //商品信息
        TProduct product = findProductById(productId);
        //图片信息
        List<TProductImage> imageList = findImagesByProductId(productId);
        List<ProductImageVO> productImageVOS = new ArrayList<>();
        for (TProductImage image : imageList) {
            ProductImageVO productImageVo = new ProductImageVO();
            productImageVo.setImageUrl(image.getImageUrl());
            productImageVo.setType(image.getType());
            productImageVOS.add(productImageVo);
        }
        //规格信息
        List<SpecNameValueVO> specVos = new ArrayList<>();
        List<TSpecName> specNames = specService.getSpecNameByProductId(productId);
        for (TSpecName name : specNames) {
            List<TSpecValue> specValues = specService.getSpecValueBySpecNameId(name.getId());
            SpecNameValueVO specVo = new SpecNameValueVO();
            specVo.setName(name.getName());
            List<SpecValueVO> specValueVos = BeanCopyUtils.copyListProperties(specValues, SpecValueVO::new);
            specVo.setValues(specValueVos);
            specVos.add(specVo);
        }
        //商品规格列表
        List<TProductSpec> productSpecs = productSpecService.getSpecsByProductId(productId);
        List<ProductSpecVO> productSpecVOS = BeanCopyUtils.copyListProperties(productSpecs, ProductSpecVO::new);
        productDetailVo.setProductId(product.getId());
        productDetailVo.setName(product.getName());
        productDetailVo.setSummary(product.getName());
        productDetailVo.setPrice(product.getPrice());
        productDetailVo.setLineationPrice(product.getLineationPrice());
        productDetailVo.setDescription(product.getDescription());
        productDetailVo.setProductImageVOS(productImageVOS);
        productDetailVo.setSpecNameValueVOS(specVos);
        productDetailVo.setProductSpecVOS(productSpecVOS);
        return productDetailVo;
    }

    public TProduct findProductById(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    public List<TProductImage> findImagesByProductId(Integer productId) {
        TProductImageExample imageExample = new TProductImageExample();
        imageExample.createCriteria().andProductIdEqualTo(productId).andStatusEqualTo(StatusEnum.VALID.getKey());
        return productImageMapper.selectByExample(imageExample);
    }
}
