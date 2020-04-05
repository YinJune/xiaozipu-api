package com.xiaozipu.merchant.service.order;


import com.xiaozipu.dao.mapper.TOrderMapper;
import com.xiaozipu.merchant.dao.entity.OrderListDO;
import com.xiaozipu.merchant.dao.mapper.OrderDao;
import com.xiaozipu.merchant.pojo.dto.order.OrderListReqDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/4/5 18:02
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Resource
    private TOrderMapper orderMapper;
    @Resource
    private OrderDao orderDao;

    /**
     * 订单列表
     *
     * @param orderListReqDTO
     * @return
     */
    @Override
    public List<OrderListDO> getOrderList(OrderListReqDTO orderListReqDTO) {
        List<OrderListDO> orderListDOS= orderDao.getOrderList(orderListReqDTO);
        return null;
    }
}
