package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: YinJunJie
 * @date: 2020/3/3 14:16
 * @description:
 */
@RestController
public class OrderController {
    private static final Logger logger= LoggerFactory.getLogger(OrderController.class);

    @GetMapping
    public ResultInfo orderList(HttpServletRequest request){
        ResultInfo resultInfo= new ResultInfo();
        return resultInfo;
    }
}
