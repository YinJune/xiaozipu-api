package com.xiaozipu.client.enums;

/**
 * @author: YinJunJie
 * @date: 2020/2/8 18:28
 * @description:
 */
public enum UserThirdTypeEnum {
    WECHAT("01","微信"),
    ALIPAY("02","支付宝");
    private String key;
    private String value;

    UserThirdTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
