package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.common.annotation.TraceLog;
import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;
import com.xiaozipu.client.pojo.vo.order.ConfirmOrderInfoVO;
import com.xiaozipu.client.pojo.vo.order.OrderDetailVO;
import com.xiaozipu.client.pojo.vo.order.OrderListVO;
import com.xiaozipu.client.service.order.OrderService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.client.dao.entity.OrderDetailDO;
import com.xiaozipu.client.dao.entity.OrderListDO;
import com.xiaozipu.common.util.MoneyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

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
    @TraceLog
    @PostMapping("/order/amount/calculate")
    public ResultInfo calculateAmount(HttpServletRequest request, @RequestBody @Validated CalculateAmountDTO calculateAmountDTO) {
        logger.info("计算商品金额:{}", JSONObject.toJSONString(calculateAmountDTO));
        ResultInfo resultInfo = new ResultInfo();
        BigDecimal amount = orderService.calculateAmount(calculateAmountDTO);
        resultInfo.setData(amount.divide(MoneyUtils.UNIT));
        return resultInfo;
    }


    /**
     * 确认订单页
     *
     * @param request
     * @return
     */
    @TraceLog
    @PostMapping("/order/confirm/info")
    public ResultInfo confirmOrderInfo(HttpServletRequest request, @RequestBody @Validated CalculateAmountDTO calculateAmountDTO) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId= (Integer) request.getAttribute("userId");
        ConfirmOrderInfoVO confirmOrderInfoVO =orderService.confirmOrderInfo(userId,calculateAmountDTO);
        resultInfo.setData(confirmOrderInfoVO);
        return resultInfo;
    }


    /**
     * 下单
     *
     * @param request
     * @return
     */
    @TraceLog
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
    @TraceLog
    @PostMapping("/order/pay")
    public ResultInfo payOrder(HttpServletRequest request, @RequestBody @Validated PlaceOrderDTO placeOrderDTO) {
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("订单支付:{}", JSONObject.toJSONString(placeOrderDTO));
        ResultInfo resultInfo = new ResultInfo();
        Integer orderId = orderService.placeOrder(userId, placeOrderDTO);
        resultInfo.setData(orderId);
        return resultInfo;
    }

    /**
     * 订单列表
     *
     * @param status 订单状态
     * @return
     */
    @TraceLog
    @PostMapping("/order/list")
    public ResultInfo orderList(HttpServletRequest request, @RequestParam(value = "status", required = false) String status, @RequestParam("currentPage") Integer currentPage) {
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("订单列表userId={} status={}", userId, status);
        ResultInfo resultInfo = new ResultInfo();
        List<OrderListDO> orderListDOS = orderService.getOrderList(userId, status, currentPage);
        List<OrderListVO> orderListVOS = BeanCopyUtils.copyListProperties(orderListDOS, OrderListVO::new);
        resultInfo.setData(orderListVOS);
        return resultInfo;
    }

    /**
     * 订单列表
     *
     * @param orderId 订单id
     * @return
     */
    @GetMapping("/order/detail/{orderId}")
    public ResultInfo getOrderDetail(HttpServletRequest request, @PathVariable("orderId") Integer orderId) {
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("订单详情userId={} orderId={}", userId, orderId);
        ResultInfo resultInfo = new ResultInfo();
        OrderDetailDO orderDetailDO = orderService.getOrderDetail(orderId);
        OrderDetailVO orderDetail= new OrderDetailVO();
        BeanUtils.copyProperties(orderDetailDO,orderDetail);
        resultInfo.setData(orderDetail);
        return resultInfo;
    }

}
