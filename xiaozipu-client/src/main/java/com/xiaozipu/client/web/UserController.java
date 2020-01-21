package com.xiaozipu.client.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.pojo.dto.CaptchaLoginDTO;
import com.xiaozipu.service.user.UserService;
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
    @Autowired
    private UserService userService;

    @PostMapping("/user/login/password")
    public ResultInfo loginPassword() {
        ResultInfo resultInfo = new ResultInfo();

        return resultInfo;
    }

    /**
     * 验证码登陆
     *
     * @param captchaLoginDto
     * @return
     */
    @PostMapping("/user/login/captcha")
    public ResultInfo loginCaptcha(CaptchaLoginDTO captchaLoginDto) {
        ResultInfo resultInfo = new ResultInfo();
        String token = userService.loginCaptcha(captchaLoginDto);
        resultInfo.setData(token);
        return resultInfo;
    }
}
