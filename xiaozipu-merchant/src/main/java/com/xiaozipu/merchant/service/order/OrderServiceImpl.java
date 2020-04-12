package com.xiaozipu.merchant.service.order;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaozipu.common.result.PageResultInfo;
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
    public PageResultInfo getOrderList(OrderListReqDTO orderListReqDTO) {
        PageHelper.startPage(orderListReqDTO.getCurrentPage(), 20);
        List<OrderListDO> orderListDOS = orderDao.getOrderList(orderListReqDTO);
        PageInfo<OrderListDO> pageInfo = new PageInfo<>(orderListDOS);
        PageResultInfo pageResultInfo = new PageResultInfo(orderListReqDTO.getCurrentPage(), pageInfo.getTotal(), orderListDOS);
        return pageResultInfo;
    }
}
