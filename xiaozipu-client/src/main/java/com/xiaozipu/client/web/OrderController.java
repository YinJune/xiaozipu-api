package com.xiaozipu.client.web;

import com.xiaozipu.client.service.order.OrderService;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 14:21
 * @description:
 */
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 下单
     *
     * @param request
     * @return
     */
    @PostMapping("/order/amount/calculate")
    public ResultInfo placeOrder(HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
//        orderService.createOrder();
        return resultInfo;
    }
}
