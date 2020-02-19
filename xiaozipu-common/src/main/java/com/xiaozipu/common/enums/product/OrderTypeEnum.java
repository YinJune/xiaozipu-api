package com.xiaozipu.common.enums.product;

/**
 * @author: YinJunJie
 * @date: 2020/2/19 20:16
 * @description:
 */
public enum OrderTypeEnum {
    ASC("1", "正序"),
    DESC("2", "倒序");
    private String key;
    private String value;

    OrderTypeEnum(String key, String value) {
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
