package com.xiaozipu.client.enums.aliyun;

/**
 * @author: YinJunJie
 * @date: 2020/2/9 22:20
 * @description:
 */
public enum SmsTypeEnum {
    LOGIN("01", "SMS_181740306");
    /**
     * 类型
     */
    private String type;
    /**
     * 阿里云模板code
     */
    private String code;

    SmsTypeEnum(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public static String getCodeByType(String type) {
        for (SmsTypeEnum smsTypeEnum : SmsTypeEnum.values()) {
            if (smsTypeEnum.getType().equals(type)) {
                return smsTypeEnum.code;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
}
