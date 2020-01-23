package com.xiaozipu.service.sms;

import com.xiaozipu.service.pojo.dto.sms.SendSmsReqDTO;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 17:36
 * @description:
 */
public interface SmsService {
    /**
     * 发送短信
     * @param sendSmsReqDTO
     */
    void sendSms(SendSmsReqDTO sendSmsReqDTO);
}
