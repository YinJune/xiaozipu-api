package com.xiaozipu.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class UrlUtils {

    private static final Logger log= LoggerFactory.getLogger(UrlUtils.class);

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
