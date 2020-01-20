package com.xiaozipu.service.product;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.entity.generator.TProduct;
import com.xiaozipu.dao.entity.generator.TProductSpecs;
import com.xiaozipu.dao.mapper.custom.ProductDao;
import com.xiaozipu.dao.mapper.generator.TProductMapper;
import com.xiaozipu.dao.mapper.generator.TProductSpecsMapper;
import com.xiaozipu.service.enums.RankingListTypeEnum;
import com.xiaozipu.service.enums.StatusEnum;
import com.xiaozipu.service.enums.error.ErrorCodeEnum;
import com.xiaozipu.service.pojo.dto.product.AddProductReqDto;
import com.xiaozipu.service.pojo.dto.product.AddSpecsReqDto;
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
    private TProductSpecsMapper specsMapper;

    /**
     * 根据商品id查询商品简要信息
     *
     * @param productId
     * @return
     */
    @Override
    public ProductSummaryDO getProductSummaryBoById(Integer productId) {
        return productDao.getProductSummaryById(productId);
//        ProductSummaryVO productSummaryVO =new ProductSummaryVO();
//        if (productSummaryDO!=null){
//            BeanUtils.copyProperties(productSummaryDO, productSummaryVO);
//        }
//        return productSummaryVO;
    }

    /**
     * 排行榜
     *
     * @param currentPage
     * @param type
     * @return
     */
    @Override
    public List<ProductSummaryDO> getRankingList(Integer currentPage, String type) {
        PageHelper.startPage(currentPage, 10);
        List<com.xiaozipu.dao.entity.custom.ProductSummaryDO> productSummaryDOList = null;
        if (RankingListTypeEnum.TIME.getKey().equals(type)) {
            productSummaryDOList = productDao.getProductList("create_time");
        } else {
            //TODO 销量排名
            productSummaryDOList = productDao.getProductList("create_time");
        }

        return productSummaryDOList;
    }

    /**
     * 添加商品
     *
     * @param addProductReqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addProduct(AddProductReqDto addProductReqDto) {
        //插入商品
        TProduct product = new TProduct();
        product.setPrice(addProductReqDto.getPrice());
        product.setLineationPrice(addProductReqDto.getLineationPrice());
        product.setName(addProductReqDto.getName());
        productMapper.insertSelective(product);
        //插入规格
        List<TProductSpecs> productSpecsList = new ArrayList<>();
        for (AddSpecsReqDto addSpecsReqDto : addProductReqDto.getAddSpecsReqDtoList()) {
            TProductSpecs productSpecs = new TProductSpecs();
            productSpecs.setProductId(product.getId());
            productSpecs.setName(addSpecsReqDto.getSpecName());
            productSpecs.setPrice(addSpecsReqDto.getSpecPrice());
            productSpecs.setStock(addSpecsReqDto.getStock());
            productSpecs.setCostPrice(addSpecsReqDto.getCostPrice());
            productSpecs.setStatus(StatusEnum.VALID.getKey());
            productSpecs.setDeleted(StatusEnum.INVALID.getKey());
            productSpecsList.add(productSpecs);
        }
        specsMapper.batchInsertSelective(productSpecsList);
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
}
