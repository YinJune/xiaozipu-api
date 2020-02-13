package com.xiaozipu.merchant.service.spec;

import com.xiaozipu.dao.entity.generator.TSpecName;
import com.xiaozipu.dao.entity.generator.TSpecValue;
import com.xiaozipu.merchant.pojo.dto.spec.AddSpecNameReqDTO;
import com.xiaozipu.merchant.pojo.dto.spec.AddSpecValueReqDTO;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 13:50
 * @description:
 */
public interface SpecService {
    /**
     * 添加规格名
     *
     * @param addSpecNameReqDto
     * @return
     */
    Integer addSpecName(AddSpecNameReqDTO addSpecNameReqDto);

    /**
     * 添加规格值
     *
     * @param addSpecValueReqDto
     * @return
     */
    Integer addSpecValue(AddSpecValueReqDTO addSpecValueReqDto);

    /**
     * 删除规格
     *
     * @param specId
     */
    void deleteSpecName(Integer specId);

    /**
     * 删除规格值
     *
     * @param valueId
     */
    void deleteSpecValue(Integer valueId);

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
