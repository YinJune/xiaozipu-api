package com.xiaozipu.client.service.product;

import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.dao.entity.generator.TProductSpecs;
import com.xiaozipu.dao.entity.generator.TProductSpecsExample;
import com.xiaozipu.dao.mapper.generator.TProductSpecsMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
     * 根据商品id查询商品属性
     *
     * @param productId
     * @return
     */
    @Override
    public List<TProductSpecs> findSpecByProductId(Integer productId) {
        return null;
    }

    /**
     * 计算商品集合金额
     *
     * @param productSpecIds
     * @return
     */
    @Override
    public BigDecimal calculateAmount(List<Integer> productSpecIds) {
        TProductSpecsExample example = new TProductSpecsExample();
        example.createCriteria().andIdIn(productSpecIds);
        List<TProductSpecs> productSpecsList = productSpecsMapper.selectByExample(example);
        if (productSpecsList.size() != productSpecIds.size() || CollectionUtils.isEmpty(productSpecsList)) {
            throw new BusinessRuntimeException("", "存在无效商品");//TODO
        }
        BigDecimal amount = BigDecimal.ZERO;
        for (TProductSpecs productSpecs : productSpecsList) {
            amount = amount.add(productSpecs.getPrice());
        }
        return amount;
    }
}
