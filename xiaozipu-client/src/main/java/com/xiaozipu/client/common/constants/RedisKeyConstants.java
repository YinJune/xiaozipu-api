package com.xiaozipu.client.common.constants;

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
    //小程序session_key
    String MP_SESSION_KEY = "mp:session_key:";
    String ALIPAY_ACCESS_TOKEN = "alipay:access_token:";
}
