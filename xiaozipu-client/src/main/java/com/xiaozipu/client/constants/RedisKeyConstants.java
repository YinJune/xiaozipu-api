package com.xiaozipu.client.constants;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/21 20:13
 */
public interface RedisKeyConstants {
    //用户token
    String USER_TOKEN = "user:token:";
    //用户验证码
    String USER_CAPTCHA = "user:captcha:";
    //用户发送验证码次数
    String SEND_CAPTCHA_TIMES = "user:captcha:times:";
}
