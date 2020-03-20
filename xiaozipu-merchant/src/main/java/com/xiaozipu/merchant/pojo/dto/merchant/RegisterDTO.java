package com.xiaozipu.merchant.pojo.dto.merchant;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/3/19 23:00
 * @description:
 */
@Data
public class RegisterDTO {
    private String phone;
    private String name;
    private String captcha;
    private String password;
}
