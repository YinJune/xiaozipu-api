package com.xiaozipu.client.service.product;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.client.pojo.dto.order.ProductSpecQuantity;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.util.MoneyUtils;
import com.xiaozipu.dao.entity.TProductSpec;
import com.xiaozipu.dao.entity.TProductSpecExample;
import com.xiaozipu.dao.mapper.TProductSpecMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * @param productSpecId
     * @return
     */
    @Override
    public BigDecimal calculateAmount(Integer productSpecId,Integer quantity) {
//        TProductSpecExample example = new TProductSpecExample();
//        List<Integer> ids=productSpecQuantities.stream().map(p -> p.getProductSpecId()).collect(Collectors.toList());
//        example.createCriteria().andIdIn(ids);
//        List<TProductSpec> productSpecsList = productSpecsMapper.selectByExample(example);
//        if (productSpecsList.size() != productSpecQuantities.size() || CollectionUtils.isEmpty(productSpecsList)) {
//            throw new BusinessRuntimeException("", "存在无效商品");//TODO
//        }
//        Map<Integer,Integer> psqMap=new HashMap<>();
//        productSpecQuantities.forEach(psq->psqMap.put(psq.getProductSpecId(),psq.getQuantity()));
//        BigDecimal amount = BigDecimal.ZERO;
//        for (TProductSpec productSpecs : productSpecsList) {
//            amount = amount.add(productSpecs.getPrice().multiply(new BigDecimal(psqMap.get(productSpecs.getId()))));
//        }

        return getById(productSpecId).getPrice().divide(MoneyUtils.UNIT).multiply(new BigDecimal(quantity));
    }

    /**
     * 获取商品规格byid
     *
     * @param productSpecId
     * @return
     */
    @Override
    public TProductSpec getById(Integer productSpecId) {
        return productSpecsMapper.selectByPrimaryKey(productSpecId);
    }

    /**
     * 批量查询商品规格根据id
     *
     * @param productSpecIds
     * @return
     */
    @Override
    public List<TProductSpec> listProductSpec(List<Integer> productSpecIds) {
        TProductSpecExample example=new TProductSpecExample();
        example.createCriteria().andIdIn(productSpecIds);
        return productSpecsMapper.selectByExample(example);
    }

    /**
     * 更新商品规格
     *
     * @param productSpec
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateProductSpec(TProductSpec productSpec) {
        productSpecsMapper.updateByPrimaryKeySelective(productSpec);
    }

    /**
     * 批量更新商品规格
     *
     * @param productSpecs
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchUpdateProductSpec(List<TProductSpec> productSpecs) {
        for (TProductSpec productSpec:productSpecs){
            updateProductSpec(productSpec);
        }
    }
}
