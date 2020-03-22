package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.common.annotation.TraceLog;
import com.xiaozipu.client.pojo.dto.CaptchaLoginDTO;
import com.xiaozipu.client.pojo.dto.user.ThirdRegisterReqDTO;
import com.xiaozipu.client.pojo.vo.UserInfoVO;
import com.xiaozipu.client.service.user.UserService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.dao.entity.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 15:03
 * @description:
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @TraceLog
    @PostMapping("/anon/user/login/password")
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
    @TraceLog
    @PostMapping("/anon/user/login/captcha")
    public ResultInfo loginCaptcha(CaptchaLoginDTO captchaLoginDto) {
        logger.info("验证码登陆:{}", JSONObject.toJSONString(captchaLoginDto));
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
    public ResultInfo thirdRegister(@RequestBody @Validated ThirdRegisterReqDTO thirdRegisterReqDTO) {
        logger.info("第三方注册:{}", JSONObject.toJSONString(thirdRegisterReqDTO));
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
//    @GetMapping("/anon/user/third/exists")
//    public ResultInfo thirdExists(@RequestParam("thirdUniqueId") String thirdUniqueId) {
//        ResultInfo resultInfo = new ResultInfo();
//       TUser user = userService.findUserByThirdUniqueId(thirdUniqueId);
//        resultInfo.setData(user);
//        return resultInfo;
//    }

    /**
     * 查询用户信息
     *
     * @param request
     * @return
     */
    @TraceLog
    @GetMapping("/user/info")
    public ResultInfo getUserInfo(HttpServletRequest request) {
        Integer userId = Integer.parseInt((String) request.getAttribute("userId"));
        TUser user = userService.findUserById(userId);
        UserInfoVO userInfoVo = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVo);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(userInfoVo);
        return resultInfo;
    }
}
