package com.xiaozipu.common.result;


/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/21 20:38
 */
public class ResultInfo<T> {
    /**
     * 返回码
     */
    private String code = "000000";
    /**
     * 消息
     */
    private String message = "请求成功";
    /**
     * 返回体
     */
    private T data;

    public ResultInfo() {
    }

    public ResultInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
