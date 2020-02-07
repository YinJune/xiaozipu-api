package com.xiaozipu.client.web;

import com.xiaozipu.client.pojo.dto.CaptchaLoginDTO;
import com.xiaozipu.client.pojo.dto.user.ThirdRegisterReqDTO;
import com.xiaozipu.client.service.user.UserService;
import com.xiaozipu.common.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//
//    /**
//     * 小程序绑定手机号
//     *
//     * @param captchaLoginDto
//     * @return
//     */
//    @PostMapping("/user/login/captcha")
//    public ResultInfo bindPhone() {
//        ResultInfo resultInfo = new ResultInfo();
//        String token = userService.loginCaptcha(captchaLoginDto);
//        resultInfo.setData(token);
//        return resultInfo;
//    }

    /**
     * 第三方注册
     *
     * @param thirdRegisterReqDTO
     * @return
     */
    @PostMapping("/anon/user/register/third")
    public ResultInfo thirdRegister(@RequestBody ThirdRegisterReqDTO thirdRegisterReqDTO) {
        ResultInfo resultInfo = new ResultInfo();
        String token = userService.thirdRegister(thirdRegisterReqDTO);
        resultInfo.setData(token);
        return resultInfo;
    }

    /**
     * 第三方用户是否已存在
     *
     * @param thirdUniqueId
     * @return
     */
    @GetMapping("/anon/user/third/exists")
    public ResultInfo thirdExists(@RequestParam("thirdUniqueId") String thirdUniqueId) {
        ResultInfo resultInfo = new ResultInfo();
        boolean exists = userService.thirdExists(thirdUniqueId);
        resultInfo.setData(exists);
        return resultInfo;
    }

}
