package com.xiaozipu.merchant.service.order;

import com.xiaozipu.common.result.PageResultInfo;
import com.xiaozipu.merchant.dao.entity.OrderListDO;
import com.xiaozipu.merchant.pojo.dto.order.OrderListReqDTO;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/4/5 18:02
 * @description:
 */
public interface OrderService {
    /**
     * 订单列表
     *
     * @param orderListReqDTO
     * @return
     */
    PageResultInfo getOrderList(OrderListReqDTO orderListReqDTO);
}
