package com.xiaozipu.client.service.order;

import com.xiaozipu.dao.entity.generator.TOrderProduct;
import com.xiaozipu.dao.mapper.generator.TOrderProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 18:16
 * @description:
 */
@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Resource
    private TOrderProductMapper orderProductMapper;

    /**
     * 批量插入
     *
     * @param orderProducts
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchInsert(List<TOrderProduct> orderProducts) {
        orderProductMapper.batchInsertSelective(orderProducts, TOrderProduct.Column.userId, TOrderProduct.Column.orderId,
                TOrderProduct.Column.productSpecId, TOrderProduct.Column.price, TOrderProduct.Column.quantity, TOrderProduct.Column.payPrice);
    }
}
