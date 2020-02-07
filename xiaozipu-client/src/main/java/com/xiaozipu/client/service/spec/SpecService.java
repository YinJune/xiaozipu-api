package com.xiaozipu.client.service.spec;

import com.xiaozipu.dao.entity.generator.TSpecName;
import com.xiaozipu.dao.entity.generator.TSpecValue;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 13:50
 * @description:
 */
public interface SpecService {


    /**
     * 根据id查询规格名称
     *
     * @param specId
     * @return
     */
    TSpecName getSpecNameById(Integer specId);

    /**
     * 根据id查询规格值
     *
     * @param valueId
     * @return
     */
    TSpecValue getSpecValueById(Integer valueId);
}
