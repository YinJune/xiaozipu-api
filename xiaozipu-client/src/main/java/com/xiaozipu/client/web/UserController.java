package com.xiaozipu.client.web;

import com.xiaozipu.common.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 15:03
 * @description:
 */
@RestController
public class UserController {
//    @Autowired
//    private UserService UserService;

    @PostMapping("/user/login/password")
    public ResultInfo loginPassword(){
        ResultInfo resultInfo=new ResultInfo();

        return resultInfo;
    }
}
