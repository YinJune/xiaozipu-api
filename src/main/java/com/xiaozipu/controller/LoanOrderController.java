package com.xiaozipu.controller;



import com.xiaozipu.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

        return null;
    }
}

