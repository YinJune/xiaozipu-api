package com.xiaozipu.client.service.spec;

import com.xiaozipu.dao.entity.TSpecName;
import com.xiaozipu.dao.entity.TSpecValue;

import java.util.List;

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

    /**
     * 根据商品id查询规格名
     *
     * @param productId
     * @return
     */
    List<TSpecName> getSpecNameByProductId(Integer productId);

    /**
     * 根据规格名id查询规格值
     *
     * @param specNameId
     * @return
     */
    List<TSpecValue> getSpecValueBySpecNameId(Integer specNameId);
}
