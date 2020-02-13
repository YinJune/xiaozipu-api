package com.xiaozipu.common.enums;

/**
 * @author: YinJunJie
 * @date: 2020/1/8 21:23
 * @description: banner状态枚举
 */
public enum BannerStatusEnum {
    VALID("1", "正常"),
    INVALID("2", "失效");
    private String key;
    private String value;

    BannerStatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
