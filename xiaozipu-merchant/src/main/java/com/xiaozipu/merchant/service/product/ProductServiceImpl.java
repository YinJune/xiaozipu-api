package com.xiaozipu.merchant.service.product;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.common.util.MoneyUtils;
import com.xiaozipu.dao.entity.TProduct;
import com.xiaozipu.dao.entity.TProductImage;
import com.xiaozipu.dao.mapper.TProductImageMapper;
import com.xiaozipu.dao.mapper.TProductMapper;
import com.xiaozipu.dao.mapper.TProductSpecMapper;
import com.xiaozipu.merchant.dao.entity.ProductListDO;
import com.xiaozipu.merchant.dao.mapper.ProductDao;
import com.xiaozipu.merchant.enums.ErrorCodeEnum;
import com.xiaozipu.merchant.pojo.dto.CommonKV;
import com.xiaozipu.merchant.pojo.dto.product.AddProductReqDTO;
import com.xiaozipu.merchant.pojo.vo.product.ProductListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
    private TProductSpecMapper specsMapper;
    @Resource
    private TProductImageMapper productImageMapper;


    /**
     * 添加商品
     *
     * @param addProductReqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addProduct(AddProductReqDTO addProductReqDto) {
        //插入商品
        TProduct product = new TProduct();
        product.setPrice(addProductReqDto.getPrice().multiply(MoneyUtils.UNIT));
        if (addProductReqDto.getLineationPrice() != null) {
            product.setLineationPrice(addProductReqDto.getLineationPrice().multiply(MoneyUtils.UNIT));
        }
        product.setName(addProductReqDto.getName());
        product.setCategoryId(addProductReqDto.getCategoryId());
        product.setStatus(StatusEnum.VALID.getKey());
        product.setReviewStatus(StatusEnum.INVALID.getKey());
        product.setDeleted(StatusEnum.INVALID.getKey());
        productMapper.insertSelective(product);
        //插入图片
        List<TProductImage> productImageList = new ArrayList<>();
        for (CommonKV commonKV : addProductReqDto.getImageList()) {
            TProductImage productImage = new TProductImage();
            productImage.setProductId(product.getId());
            productImage.setStatus(StatusEnum.VALID.getKey());
            productImage.setType(commonKV.getKey());
            productImage.setImageUrl(commonKV.getValue());
            productImageList.add(productImage);
        }
        productImageMapper.batchInsertSelective(productImageList, TProductImage.Column.productId, TProductImage.Column.status,
                TProductImage.Column.type, TProductImage.Column.imageUrl);
        return product.getId();
    }

    /**
     * 更新商品状态
     *
     * @param productId
     * @param status
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateProductStatus(Integer productId, String status) {
        TProduct product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            throw new BusinessRuntimeException(ErrorCodeEnum.SYS_ERROR.getCode(), ErrorCodeEnum.SYS_ERROR.getMessage());
        }
        product.setStatus(status);
        product.setUpdateTime(new Date());
        productMapper.updateByPrimaryKeySelective(product);
    }

    /**
     * @param status
     * @return
     */
    @Override
    public List<ProductListVO> getProductList(Integer currentPage,String status) {
        PageHelper.startPage(currentPage,10);
        List<ProductListDO> productListDOS= productDao.getProductList(status);
        List<ProductListVO> productListVOS=BeanCopyUtils.copyListProperties(productListDOS,ProductListVO::new);
        return productListVOS;
    }
}
