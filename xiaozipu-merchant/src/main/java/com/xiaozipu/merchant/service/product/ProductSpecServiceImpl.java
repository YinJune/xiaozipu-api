package com.xiaozipu.merchant.service.product;

import com.xiaozipu.common.enums.StatusEnum;
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
            productSpecs.setCostPrice(addSpecsReqDTO.getCostPrice());
            productSpecs.setPrice(addSpecsReqDTO.getPrice());
            productSpecs.setDeleted(StatusEnum.INVALID.getKey());
            productSpecs.setStatus(StatusEnum.VALID.getKey());
            productSpecs.setStock(addSpecsReqDTO.getStock());
//            productSpecs.setName();
            productSpecsList.add(productSpecs);
        }
        productSpecsMapper.batchInsertSelective(productSpecsList);
    }
}
