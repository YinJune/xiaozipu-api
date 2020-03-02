package com.xiaozipu.merchant.service.product;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.util.MoneyUtils;
import com.xiaozipu.dao.entity.generator.TProductSpec;
import com.xiaozipu.dao.mapper.generator.TProductSpecMapper;
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
    private TProductSpecMapper productSpecsMapper;

    /**
     * 添加商品规格
     *
     * @param addProductSpecReqDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addProductSpec(AddProductSpecReqDTO addProductSpecReqDTO) {
        List<TProductSpec> productSpecsList = new ArrayList<>();
        for (AddSpecsReqDTO addSpecsReqDTO : addProductSpecReqDTO.getSpecsReqDTOList()) {
            TProductSpec productSpecs = new TProductSpec();
            productSpecs.setProductId(addProductSpecReqDTO.getProductId());
            productSpecs.setSpec(addSpecsReqDTO.getSpecs());
            productSpecs.setName(addSpecsReqDTO.getName());
            productSpecs.setPrice(addSpecsReqDTO.getPrice().multiply(MoneyUtils.UNIT));
            productSpecs.setCostPrice(addSpecsReqDTO.getCostPrice().multiply(MoneyUtils.UNIT));
            productSpecs.setStock(addSpecsReqDTO.getStock());
            productSpecs.setStatus(StatusEnum.VALID.getKey());
            productSpecs.setDeleted(StatusEnum.INVALID.getKey());
            productSpecs.setSpecImageUrl(addSpecsReqDTO.getSpecImageUrl());
            productSpecsList.add(productSpecs);
        }
        productSpecsMapper.batchInsertSelective(productSpecsList, TProductSpec.Column.price, TProductSpec.Column.productId, TProductSpec.Column.spec, TProductSpec.Column.costPrice, TProductSpec.Column.stock, TProductSpec.Column.status, TProductSpec.Column.deleted, TProductSpec.Column.specImageUrl);
    }
}
