package com.xiaozipu.common.enums.product;

/**
 * @author: YinJunJie
 * @date: 2020/2/19 20:16
 * @description:
 */
public enum OrderTypeEnum {
    ASC("asc", "正序"),
    DESC("desc", "倒序");
    private String type;
    private String value;

    public static OrderTypeEnum getOrderTypeEnumByType(String type) {
        for (OrderTypeEnum orderTypeEnum : OrderTypeEnum.values()) {
            if (orderTypeEnum.getType().equals(type)) {
                return orderTypeEnum;
            }
        }
        return null;
    }

    OrderTypeEnum(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
