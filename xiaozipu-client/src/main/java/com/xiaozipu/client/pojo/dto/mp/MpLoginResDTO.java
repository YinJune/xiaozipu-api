package com.xiaozipu.client.pojo.dto.mp;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/11 14:59
 * @description: 小程序登陆返回体
 */
@Data
public class MpLoginResDTO {
    private String openId;
    /**
     * 登陆token 如果该用户已注册时返回
     */
    private String token;
}
