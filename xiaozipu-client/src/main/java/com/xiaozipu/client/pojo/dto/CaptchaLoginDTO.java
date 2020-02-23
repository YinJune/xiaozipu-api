package com.xiaozipu.client.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    /**
     * 验证码
     */
    private String captcha;
}
