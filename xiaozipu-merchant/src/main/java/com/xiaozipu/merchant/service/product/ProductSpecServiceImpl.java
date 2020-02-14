package com.xiaozipu.merchant.service.product;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.util.MoneyUtils;
import com.xiaozipu.dao.entity.generator.TProductSpecs;
import com.xiaozipu.dao.mapper.generator.TProductSpecsMapper;
import com.xiaozipu.merchant.pojo.dto.product.AddProductSpecReqDTO;
import com.xiaozipu.merchant.pojo.dto.product.AddSpecsReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:19
 * @description:
 */
@Service
public class ProductSpecServiceImpl implements ProductSpecService {
    @Resource
    private TProductSpecsMapper productSpecsMapper;

    /**
     * 添加商品规格
     *
     * @param addProductSpecReqDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addProductSpec(AddProductSpecReqDTO addProductSpecReqDTO) {
        List<TProductSpecs> productSpecsList = new ArrayList<>();
        for (AddSpecsReqDTO addSpecsReqDTO : addProductSpecReqDTO.getSpecsReqDTOList()) {
            TProductSpecs productSpecs = new TProductSpecs();
            productSpecs.setProductId(addProductSpecReqDTO.getProductId());
            productSpecs.setSpec(addSpecsReqDTO.getSpecs());
            productSpecs.setPrice(addSpecsReqDTO.getPrice().multiply(MoneyUtils.UNIT));
            productSpecs.setCostPrice(addSpecsReqDTO.getCostPrice().multiply(MoneyUtils.UNIT));
            productSpecs.setStock(addSpecsReqDTO.getStock());
            productSpecs.setStatus(StatusEnum.VALID.getKey());
            productSpecs.setDeleted(StatusEnum.INVALID.getKey());
            productSpecs.setSpecImageUrl(addSpecsReqDTO.getSpecImageUrl());
            productSpecsList.add(productSpecs);
        }
        productSpecsMapper.batchInsertSelective(productSpecsList, TProductSpecs.Column.price, TProductSpecs.Column.productId, TProductSpecs.Column.spec, TProductSpecs.Column.costPrice, TProductSpecs.Column.stock, TProductSpecs.Column.status, TProductSpecs.Column.deleted, TProductSpecs.Column.specImageUrl);
    }
}
