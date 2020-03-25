package com.xiaozipu.client.web;

import com.xiaozipu.client.service.alipay.AlipayService;
import com.xiaozipu.common.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AlipayController {

    @Autowired
    private AlipayService alipayService;

    @GetMapping("/anon/alipay/auth")
    public ResultInfo auth(HttpServletRequest request, @RequestParam("authCode")String authCode){
        ResultInfo resultInfo=new ResultInfo();
        alipayService.auth(authCode);
        return resultInfo;
    }
}
