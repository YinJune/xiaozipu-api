package com.xiaozipu.client.web;

import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/3/27 17:14
 * @description:
 */
@RestController
public class AfterSalesOrderController {
    private static final Logger logger = LoggerFactory.getLogger(AfterSalesOrderController.class);

    /**
     * 退货
     *
     * @return
     */
    @PostMapping("/after-sales/order/refund")
    public ResultInfo refundOrder() {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }

    /**
     * 换货
     *
     * @return
     */
    @PostMapping("/after-sales/order/exchange")
    public ResultInfo exchangeOrder() {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }

    /**
     * 换货
     *
     * @return
     */
    @PostMapping("/after-sales/order/list")
    public ResultInfo orderList() {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }
}
