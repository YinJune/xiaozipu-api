package com.xiaozipu.third.service.sms;

import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 17:36
 * @description:
 */
public interface AliyunSmsService {
    /**
     * 发送短信
     *
     * @param code
     */
    void sendSms(String code, String phone, Map paramMap);
}
