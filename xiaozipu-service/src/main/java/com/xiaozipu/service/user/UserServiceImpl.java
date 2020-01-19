package com.xiaozipu.service.user;

import com.xiaozipu.service.pojo.dto.CaptchaLoginDto;
import org.springframework.stereotype.Service;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 20:11
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 验证码登陆
     *
     * @param captchaLoginDto
     * @return
     */
    @Override
    public String loginCaptcha(CaptchaLoginDto captchaLoginDto) {

        return null;
    }
}
