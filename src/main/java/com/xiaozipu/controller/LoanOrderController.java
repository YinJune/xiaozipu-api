package com.xiaozipu.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.xiaozipu.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * <p>
 * 借款订单 前端控制器
 * </p>
 *
 * @author along
 * @since 2018-12-06
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class LoanOrderController {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult test(){
        log.info("**********************************测试开始");
        boolean empty = StrUtil.isEmpty("");


        System.out.println("成功");

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result= HttpUtil.post("https://www.baidu.com", paramMap);
        return null;
    }
}

