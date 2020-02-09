package com.xiaozipu.client.service.sms;

/**
 * @author: YinJunJie
 * @date: 2020/2/9 22:09
 * @description:
 */
public interface SmsService {
    /**
     * 发送短信
     *
     * @param code
     * @param phone
     */
    void sendSms(String code, String phone);
}
