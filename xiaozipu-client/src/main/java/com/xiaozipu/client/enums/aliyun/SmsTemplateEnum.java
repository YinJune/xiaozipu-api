package com.xiaozipu.client.enums.aliyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/26 16:32
 * @description:
 */
public enum SmsTemplateEnum {
    REGISTER("SMS_181740306", new ArrayList<>(Arrays.asList("code")));
    private String code;
    private List<String> paramNames;

    SmsTemplateEnum(String code, List<String> paramNames) {
        this.code = code;
        this.paramNames = paramNames;
    }

    public static SmsTemplateEnum getParamNameByCode(String code) {
        for (SmsTemplateEnum smsTemplateEnum : SmsTemplateEnum.values()) {
            if (smsTemplateEnum.code.equals(code)) {
                return smsTemplateEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public List<String> getParamNames() {
        return paramNames;
    }
}
