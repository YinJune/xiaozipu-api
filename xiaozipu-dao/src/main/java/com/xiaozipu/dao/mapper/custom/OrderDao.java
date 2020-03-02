package com.xiaozipu.dao.mapper.custom;

import com.xiaozipu.dao.entity.custom.OrderDetailDO;
import com.xiaozipu.dao.entity.custom.OrderListDO;
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
    OrderDetailDO getOrderDetail(Integer orderId);
}
