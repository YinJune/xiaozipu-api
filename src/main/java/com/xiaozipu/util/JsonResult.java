package com.xiaozipu.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * json返回值
 *
 * @author sfc
 * @description
 */
public class JsonResult {

    /**
     * 兼容原来的返回值
     *
     * @param code
     * @param result
     * @param data
     * @return
     */
    public static Map<String, Object> map(Integer code, boolean result, Object data) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", code);
        resp.put("result", result);
        resp.put("message", JSON.toJSONString(data));
        return resp;
    }

    /**
     * @param code    错误code
     * @param message 错误信息
     * @param data    返回值
     * @return
     */
    public static Map<String, Object> map(Integer code, String message, Object data) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", code);
        resp.put("msg", message);
        resp.put("data", JSON.toJSONString(data));
        return resp;
    }

    /**
     * @param code     错误code
     * @param message  错误信息
     * @param jsonData String返回值
     * @return
     */
    public static Map<String, Object> map(Integer code, String message, String jsonData) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", code);
        resp.put("msg", message);
        resp.put("data", jsonData);
        return resp;
    }
}
