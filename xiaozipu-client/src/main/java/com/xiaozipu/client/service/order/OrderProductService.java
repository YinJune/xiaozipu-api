package com.xiaozipu.client.service.order;

import com.xiaozipu.dao.entity.TOrderProduct;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 18:16
 * @description:
 */
public interface OrderProductService {
    /**
     * 批量插入
     *
     * @param orderProducts
     */
    void batchInsert(List<TOrderProduct> orderProducts);
}
