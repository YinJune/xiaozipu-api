package com.xiaozipu.service.user;

import com.xiaozipu.dao.entity.generator.TUser;
import com.xiaozipu.service.pojo.dto.CaptchaLoginDTO;

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
    String loginCaptcha(CaptchaLoginDTO captchaLoginDto);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    TUser getUserByPhone(String phone);
}
