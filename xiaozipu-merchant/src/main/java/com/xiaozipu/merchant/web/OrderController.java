package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.dao.entity.TOrder;
import com.xiaozipu.merchant.common.annotation.TraceLog;
import com.xiaozipu.merchant.dao.entity.OrderListDO;
import com.xiaozipu.merchant.pojo.dto.order.OrderListReqDTO;
import com.xiaozipu.merchant.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/3/3 14:16
 * @description:
 */
@RestController
public class OrderController {
    private static final Logger logger= LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @TraceLog(desc = "订单列表")
    @PostMapping("/order/list")
    public ResultInfo orderList(HttpServletRequest request, @RequestBody OrderListReqDTO orderListReqDTO){
        ResultInfo resultInfo= new ResultInfo();
        List<OrderListDO> orderListDOS=orderService.getOrderList(orderListReqDTO);
        return resultInfo;
    }
}
