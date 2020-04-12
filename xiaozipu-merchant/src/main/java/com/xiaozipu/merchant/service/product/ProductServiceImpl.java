package com.xiaozipu.merchant.service.product;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.enums.serial.SerialNoTypeEnum;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.result.PageResultInfo;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.common.util.MoneyUtils;
import com.xiaozipu.common.util.SerialNoUtils;
import com.xiaozipu.dao.entity.TProduct;
import com.xiaozipu.dao.entity.TProductImage;
import com.xiaozipu.dao.entity.TProductImageExample;
import com.xiaozipu.dao.entity.TProductSpec;
import com.xiaozipu.dao.mapper.TProductImageMapper;
import com.xiaozipu.dao.mapper.TProductMapper;
import com.xiaozipu.dao.mapper.TProductSpecMapper;
import com.xiaozipu.merchant.dao.entity.ProductListDO;
import com.xiaozipu.merchant.dao.entity.ProductSummaryDO;
import com.xiaozipu.merchant.dao.mapper.ProductDao;
import com.xiaozipu.merchant.enums.ErrorCodeEnum;
import com.xiaozipu.merchant.pojo.dto.CommonKV;
import com.xiaozipu.merchant.pojo.dto.product.AddProductReqDTO;
import com.xiaozipu.merchant.pojo.vo.product.ProductDetailVO;
import com.xiaozipu.merchant.pojo.vo.product.ProductImageVO;
import com.xiaozipu.merchant.pojo.vo.product.ProductListVO;
import com.xiaozipu.merchant.pojo.vo.product.ProductSpecVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ProductSpecService productSpecService;
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
        product.setCode(SerialNoUtils.generateSerialNo(SerialNoTypeEnum.SHOP_ORDER));
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
    public PageResultInfo getProductList(Integer currentPage, String status) {
        Page page = PageHelper.startPage(currentPage, 10);
        List<ProductListDO> productListDOS = productDao.getProductList(status);
        PageInfo<ProductListDO> pageInfo = new PageInfo<ProductListDO>(page.getResult());
        List<ProductListVO> productListVOS = BeanCopyUtils.copyListProperties(productListDOS, ProductListVO::new, (productListDO, productListVO) -> {
            productListVO.setProductPrice(productListDO.getPrice().divide(MoneyUtils.UNIT));
        });
        PageResultInfo pageResultInfo = new PageResultInfo(currentPage, pageInfo.getTotal(), productListVOS);
        return pageResultInfo;
    }

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
     * 商品详情
     *
     * @param productId
     * @return
     */
    @Override
    public ProductDetailVO getProductDetail(Integer productId) {
        TProduct product=productMapper.selectByPrimaryKey(productId);
        List<TProductSpec> productSpecs=productSpecService.getProductSpecsByProductId(product.getId());
        TProductImageExample imageExample=new TProductImageExample();
        imageExample.createCriteria().andProductIdEqualTo(productId).andStatusEqualTo(StatusEnum.VALID.getKey());
        List<TProductImage> productImages=productImageMapper.selectByExample(imageExample);
        List<ProductImageVO> productImageVOS=BeanCopyUtils.copyListProperties(productImages,ProductImageVO::new);
        List<ProductSpecVO> productSpecVOS=BeanCopyUtils.copyListProperties(productSpecs,ProductSpecVO::new,(spec,vo)->{
            vo.setCostPrice(spec.getCostPrice().divide(MoneyUtils.UNIT));
            vo.setPrice(spec.getPrice().divide(MoneyUtils.UNIT));
        });
        ProductDetailVO productDetailVO=new ProductDetailVO();
        BeanUtils.copyProperties(product,productDetailVO);
        productDetailVO.setProductImageVOS(productImageVOS);
        productDetailVO.setProductSpecVOS(productSpecVOS);
        return productDetailVO;
    }
}
