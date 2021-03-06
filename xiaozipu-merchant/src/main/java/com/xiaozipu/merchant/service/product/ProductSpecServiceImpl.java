package com.xiaozipu.merchant.service.product;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.util.MoneyUtils;
import com.xiaozipu.dao.entity.TProductSpec;
import com.xiaozipu.dao.entity.TProductSpecExample;
import com.xiaozipu.dao.mapper.TProductSpecMapper;
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
            productSpecs.setValueIds(addSpecsReqDTO.getValueIds());
            productSpecs.setSpecName(addSpecsReqDTO.getSpecName());
            productSpecs.setPrice(addSpecsReqDTO.getPrice().multiply(MoneyUtils.UNIT));
            productSpecs.setCostPrice(addSpecsReqDTO.getCostPrice().multiply(MoneyUtils.UNIT));
            productSpecs.setStock(addSpecsReqDTO.getStock());
            productSpecs.setStatus(StatusEnum.VALID.getKey());
            productSpecs.setDeleted(StatusEnum.INVALID.getKey());
            productSpecs.setSpecImageUrl(addSpecsReqDTO.getSpecImageUrl());
            productSpecsList.add(productSpecs);
        }
        productSpecsMapper.batchInsertSelective(productSpecsList, TProductSpec.Column.price, TProductSpec.Column.productId, TProductSpec.Column.specValue, TProductSpec.Column.costPrice, TProductSpec.Column.stock, TProductSpec.Column.status, TProductSpec.Column.deleted, TProductSpec.Column.specName,TProductSpec.Column.specImageUrl);
    }

    /**
     * 根据商品id查规格
     *
     * @param productId
     * @return
     */
    @Override
    public List<TProductSpec> getProductSpecsByProductId(Integer productId) {
        TProductSpecExample example=new TProductSpecExample();
        example.createCriteria().andProductIdEqualTo(productId).andDeletedEqualTo(StatusEnum.INVALID.getKey());
        return productSpecsMapper.selectByExample(example);
    }
}
