package com.xiaozipu.service.pojo.dto.sms;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 18:38
 * @description:
 */
@Data
public class SendSmsReqDTO {
    private String phone;
    private String type;
}
