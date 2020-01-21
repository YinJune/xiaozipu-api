package com.xiaozipu.service.product;

import com.xiaozipu.dao.entity.generator.TProductSpecs;
import com.xiaozipu.dao.mapper.generator.TProductSpecsMapper;
import com.xiaozipu.service.enums.StatusEnum;
import com.xiaozipu.service.pojo.dto.product.AddProductSpecReqDTO;
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
     * @param addProductSpecReqDTOS
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addProductSpec(List<AddProductSpecReqDTO> addProductSpecReqDTOS) {
        List<TProductSpecs> productSpecsList=new ArrayList<>();
        for (AddProductSpecReqDTO addProductSpecReqDTO:addProductSpecReqDTOS){
            TProductSpecs productSpecs=new TProductSpecs();
            productSpecs.setProductId(addProductSpecReqDTO.getProductId());
            productSpecs.setCostPrice(addProductSpecReqDTO.getCostPrice());
            productSpecs.setPrice(addProductSpecReqDTO.getPrice());
            productSpecs.setDeleted(StatusEnum.INVALID.getKey());
            productSpecs.setStatus(StatusEnum.VALID.getKey());
            productSpecs.setStock(addProductSpecReqDTO.getStock());
//            productSpecs.setName();
            productSpecsList.add(productSpecs);
        }
        productSpecsMapper.batchInsertSelective(productSpecsList);
    }
}
