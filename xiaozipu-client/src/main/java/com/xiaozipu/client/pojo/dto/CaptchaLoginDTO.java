package com.xiaozipu.client.pojo.dto;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 20:14
 * @description:
 */
@Data
public class CaptchaLoginDTO {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String captcha;
}
