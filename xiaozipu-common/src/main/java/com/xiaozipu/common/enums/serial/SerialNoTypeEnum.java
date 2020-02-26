package com.xiaozipu.common.enums.serial;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 15:39
 * @description:
 */
public enum SerialNoTypeEnum {
    SHOP_ORDER("01", "商城订单");
    private String type;
    private String desc;

    SerialNoTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
