package com.xiaozipu.common.util;


import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/22 0:07
 */
public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    //无参方式
    public static String getForResult(String url) throws Exception {
       return getWithParams(url, new HashMap());
    }

    //有参方式
    public static String getWithParams(String url, Map<String, Object> params) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            // 创建Get请求
            url = joinParam(url, params);
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(2000) //服务器响应超时时间
                    .setConnectTimeout(2000) //连接服务器超时时间
                    .build();
            httpGet.setConfig(requestConfig);
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            logger.info("响应状态为:{}", response.getStatusLine());
            if (responseEntity != null) {
                String result=EntityUtils.toString(responseEntity);
                logger.info("响应内容长度为：{}", responseEntity.getContentLength());
                logger.info("响应内容为：{}", result);
                return result;
            }
            return null;
        } catch (Exception e) {
            logger.error("url:{}请求异常：{}", url, e);
            throw e;
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("url:{}关闭连接异常：{}", url, e);
                throw e;
            }
        }
    }

    /**
     * 拼接get请求参数
     *
     * @param url
     * @param params
     * @return
     */
    private static String joinParam(String url, Map<String, Object> params) {
        if (params == null || params.size() == 0) {
            return url;
        }

        StringBuilder urlBuilder = new StringBuilder(url);
        urlBuilder.append("?");

        int counter = 0;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                continue;
            }

            if (counter == 0) {
                urlBuilder.append(key).append("=").append(value);
            } else {
                urlBuilder.append("&").append(key).append("=").append(value);
            }
            counter++;
        }

        return urlBuilder.toString();
    }
}
