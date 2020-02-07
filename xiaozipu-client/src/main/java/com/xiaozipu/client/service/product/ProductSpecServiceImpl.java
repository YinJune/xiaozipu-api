package com.xiaozipu.client.service.product;

import com.xiaozipu.dao.mapper.generator.TProductSpecsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:19
 * @description:
 */
@Service
public class ProductSpecServiceImpl implements ProductSpecService {
    @Resource
    private TProductSpecsMapper productSpecsMapper;

}
