package com.xiaozipu.client.pojo.dto.sms;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 18:38
 * @description:
 */
@Data
public class SendSmsReqDTO {
    /**
     * 发送手机号
     */
    private String phone;
    /**
     * 短信类型 01：登陆
     */
    private String type;
}
