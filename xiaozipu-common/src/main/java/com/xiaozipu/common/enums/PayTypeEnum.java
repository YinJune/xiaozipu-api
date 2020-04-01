package com.xiaozipu.common.enums;

/**
 * @author: YinJunJie
 * @date: 2020/4/1 19:32
 * @description:
 */
public enum PayTypeEnum {
    WX("1","微信"),
    ZFB("2","支付宝");
    private String key;
    private String value;

    PayTypeEnum(String key, String value) {
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
