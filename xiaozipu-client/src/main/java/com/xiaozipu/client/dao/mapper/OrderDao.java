package com.xiaozipu.client.dao.mapper;

import com.xiaozipu.client.dao.entity.OrderDetailDO;
import com.xiaozipu.client.dao.entity.OrderListDO;
import org.apache.ibatis.annotations.Param;

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
     * @param userId
     * @param status
     * @return
     */
    List<OrderListDO> getOrderList(@Param("userId") Integer userId, @Param("status") String status);

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    OrderDetailDO getOrderDetail(@Param("orderId") Integer orderId);
}
