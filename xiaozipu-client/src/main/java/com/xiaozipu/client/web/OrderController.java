package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;
import com.xiaozipu.client.service.order.OrderService;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

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
     * 计算金额
     *
     * @param request
     * @return
     */
    @PostMapping("/order/amount/calculate")
    public ResultInfo calculateAmount(HttpServletRequest request, @RequestBody @Validated CalculateAmountDTO calculateAmountDTO) {
        logger.info("计算商品金额:{}", JSONObject.toJSONString(calculateAmountDTO));
        ResultInfo resultInfo = new ResultInfo();
        BigDecimal amount = orderService.calculateAmount(calculateAmountDTO);
        resultInfo.setData(amount);
        return resultInfo;
    }


    /**
     * 下单
     *
     * @param request
     * @return
     */
    @PostMapping("/order/place")
    public ResultInfo placeOrder(HttpServletRequest request, @RequestBody @Validated PlaceOrderDTO placeOrderDTO) {
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("计算商品金额:{}", JSONObject.toJSONString(placeOrderDTO));
        ResultInfo resultInfo = new ResultInfo();
        Integer orderId = orderService.placeOrder(userId, placeOrderDTO);
        resultInfo.setData(orderId);
        return resultInfo;
    }

    /**
     * 支付
     *
     * @param request
     * @return
     */
    @PostMapping("/order/pay")
    public ResultInfo payOrder(HttpServletRequest request, @RequestBody @Validated PlaceOrderDTO placeOrderDTO) {
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("订单支付:{}", JSONObject.toJSONString(placeOrderDTO));
        ResultInfo resultInfo = new ResultInfo();
        Integer orderId = orderService.placeOrder(userId, placeOrderDTO);
        resultInfo.setData(orderId);
        return resultInfo;
    }

}
