package com.xiaozipu.client.service.product;

import com.xiaozipu.client.enums.StatusEnum;
import com.xiaozipu.client.pojo.dto.order.ProductSpecQuantity;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.dao.entity.generator.TProductSpec;
import com.xiaozipu.dao.entity.generator.TProductSpecExample;
import com.xiaozipu.dao.mapper.generator.TProductSpecMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
     * 根据商品id查询商品属性
     *
     * @param productId
     * @return
     */
    @Override
    public List<TProductSpec> getSpecsByProductId(Integer productId) {
        TProductSpecExample example = new TProductSpecExample();
        example.createCriteria().andProductIdEqualTo(productId).andStatusEqualTo(StatusEnum.VALID.getKey()).andDeletedEqualTo(StatusEnum.INVALID.getKey());
        return productSpecsMapper.selectByExample(example);
    }

    /**
     * 计算商品集合金额
     *
     * @param productSpecQuantities
     * @return
     */
    @Override
    public BigDecimal calculateAmount(List<ProductSpecQuantity> productSpecQuantities) {
        TProductSpecExample example = new TProductSpecExample();
        List<Integer> ids=productSpecQuantities.stream().map(p -> p.getProductSpecId()).collect(Collectors.toList());
        example.createCriteria().andIdIn(ids);
        List<TProductSpec> productSpecsList = productSpecsMapper.selectByExample(example);
        if (productSpecsList.size() != productSpecQuantities.size() || CollectionUtils.isEmpty(productSpecsList)) {
            throw new BusinessRuntimeException("", "存在无效商品");//TODO
        }
        BigDecimal amount = BigDecimal.ZERO;
        for (TProductSpec productSpecs : productSpecsList) {
            amount = amount.add(productSpecs.getPrice());
        }
        return amount;
    }

    /**
     * 获取商品规格byid
     *
     * @param productSpecId
     * @return
     */
    @Override
    public TProductSpec getProductSpecById(Integer productSpecId) {
        return productSpecsMapper.selectByPrimaryKey(productSpecId);
    }
}
