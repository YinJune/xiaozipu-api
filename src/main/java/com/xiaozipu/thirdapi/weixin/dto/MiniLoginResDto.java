package com.xiaozipu.thirdapi.weixin.dto;

import lombok.Data;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/22 0:24
 */
@Data
public class MiniLoginResDto {
    private String openid;
    private String session_key;
    private String unionid;
    private String errcode;
    private String errmsg;
}
