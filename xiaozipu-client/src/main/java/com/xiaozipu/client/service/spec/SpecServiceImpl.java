package com.xiaozipu.client.service.spec;

import com.xiaozipu.dao.entity.generator.TSpecName;
import com.xiaozipu.dao.entity.generator.TSpecValue;
import com.xiaozipu.dao.mapper.generator.TSpecNameMapper;
import com.xiaozipu.dao.mapper.generator.TSpecValueMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 13:50
 * @description:
 */
@Service
public class SpecServiceImpl implements SpecService {
    @Resource
    private TSpecNameMapper specNameMapper;
    @Resource
    private TSpecValueMapper specValueMapper;

    /**
     * 根据id查询规格名称
     *
     * @param specId
     * @return
     */
    @Override
    public TSpecName getSpecNameById(Integer specId) {
        return specNameMapper.selectByPrimaryKey(specId);
    }

    /**
     * 根据id查询规格值
     *
     * @param valueId
     * @return
     */
    @Override
    public TSpecValue getSpecValueById(Integer valueId) {
        return specValueMapper.selectByPrimaryKey(valueId);
    }
}
