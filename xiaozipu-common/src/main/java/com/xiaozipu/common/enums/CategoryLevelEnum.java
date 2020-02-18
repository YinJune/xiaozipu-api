package com.xiaozipu.common.enums;

/**
 * @author: YinJunJie
 * @date: 2020/2/18 14:47
 * @description:
 */
public enum CategoryLevelEnum {
    ONE("1", "一级"),
    TWO("2", "二级"),
    THREE("3", "三级");
    private String key;
    private String value;

    CategoryLevelEnum(String key, String value) {
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
