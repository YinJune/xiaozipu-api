package com.xiaozipu.client.web;

import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: YinJunJie
 * @date: 2020/3/25 19:38
 * @description:
 */
@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    /**
     * 微信支付回调
     *
     * @param request
     * @return
     */
    @GetMapping("/notify/wxpay/order")
    public ResultInfo dealOrder(HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }
}
