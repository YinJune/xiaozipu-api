package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.merchant.pojo.dto.merchant.RegisterDTO;
import com.xiaozipu.merchant.service.merchant.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/3/4 22:10
 * @description: 商户控制器
 */
@RestController
public class MerchantController {
    private static final Logger logger= LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    private MerchantService merchantService;
    /**
     * 注册
     * @return
     */
    @PostMapping("/register")
    public ResultInfo register(RegisterDTO registerDTO){
        ResultInfo resultInfo=new ResultInfo();
//        merchantService.register(registerDTO);
        return resultInfo;
    }
    /**
     * 登陆
     * @return
     */
    @PostMapping("/login")
    public ResultInfo login(){
        ResultInfo resultInfo=new ResultInfo();
        return resultInfo;
    }
}
