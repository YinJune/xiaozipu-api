package com.xiaozipu.service.enums;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 12:32
 * @description:
 */
public enum  StatusEnum {
    VALID("1","生效"),
    INVALID("2","失效");
    private String key;
    private String value;

    StatusEnum(String key, String value) {
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
