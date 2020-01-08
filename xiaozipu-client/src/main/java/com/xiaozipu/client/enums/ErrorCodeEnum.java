package com.xiaozipu.client.enums;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/21 20:13
 */
public enum ErrorCodeEnum {
    /**
     * eg:001001001
     * 前三位 模块 中间 功能 后三位 具体
     */
    SUCCESS("000000","请求成功"),
    SYS_ERROR("999999","系统异常"),
    ;

    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
