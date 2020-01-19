package com.xiaozipu.service.pojo.dto;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 20:14
 * @description:
 */
@Data
public class CaptchaLoginDto {
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 验证码
     */
    private String captcha;
}
