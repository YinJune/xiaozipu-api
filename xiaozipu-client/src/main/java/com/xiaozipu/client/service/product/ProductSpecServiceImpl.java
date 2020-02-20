package com.xiaozipu.client.service.product;

import com.xiaozipu.dao.entity.generator.TProductSpecs;
import com.xiaozipu.dao.mapper.generator.TProductSpecsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
