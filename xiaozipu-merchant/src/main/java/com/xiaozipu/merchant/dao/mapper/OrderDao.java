package com.xiaozipu.merchant.dao.mapper;

import com.xiaozipu.merchant.dao.entity.OrderListDO;
import com.xiaozipu.merchant.pojo.dto.order.OrderListReqDTO;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:28
 * @description:
 */
public interface OrderDao {
    /**
     * 订单列表
     *
     * @param orderListReqDTO
     * @return
     */
    List<OrderListDO> getOrderList(OrderListReqDTO orderListReqDTO);
}
