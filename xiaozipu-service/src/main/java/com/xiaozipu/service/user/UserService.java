package com.xiaozipu.service.user;

import com.xiaozipu.service.pojo.dto.CaptchaLoginDto;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 20:10
 * @description:
 */
public interface UserService {
    /**
     * 验证码登陆
     *
     * @param captchaLoginDto
     * @return
     */
    String loginCaptcha(CaptchaLoginDto captchaLoginDto);
}
