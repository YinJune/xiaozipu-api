package com.xiaozipu.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class UrlUtil {

    /**
     * 拼接get请求url
     *
     * @param url
     * @param params
     * @return
     */
    public static String getRequsetUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        String redirectUrl = builder.toString();
        log.info("redirectUrl url:{}", redirectUrl);
        return redirectUrl;
    }
}
