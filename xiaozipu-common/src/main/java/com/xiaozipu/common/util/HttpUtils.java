package com.xiaozipu.common.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

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
        logger.info("请求url:{},参数:{}",url, JSONObject.toJSONString(params));
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

    public void postFormUrlEncodeWithParams(String url, Map<String, String> params) {
        List<NameValuePair> pairs = generatePairs(params);

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(2000) //服务器响应超时时间
                    .setConnectTimeout(2000) //连接服务器超时时间
                    .build();
            httpPost.setConfig(requestConfig);

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, "utf-8");
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            // 由客户端执行(发送)请求
            response = httpClient.execute(httpPost);
            System.out.println("响应状态为:" + response.getStatusLine());
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
    }

    private List<NameValuePair> generatePairs(Map<String, String> params) {
        if (params == null || params.size() == 0) {
            return Collections.emptyList();
        }
        List<NameValuePair> pairs = new ArrayList();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                continue;
            }
            pairs.add(new BasicNameValuePair(key, value));
        }
        return pairs;
    }

    public String postJson(String url, Map params) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(2000) //服务器响应超时时间
                    .setConnectTimeout(2000) //连接服务器超时时间
                    .build();
            httpPost.setConfig(requestConfig);

            StringEntity entity = new StringEntity(JSONObject.toJSONString(params), "utf-8");//也可以直接使用JSONObject
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json;charset=utf8");
            // 由客户端执行(发送)请求
            response = httpClient.execute(httpPost);
            System.out.println("响应状态为:" + response.getStatusLine());
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
//                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                String result = EntityUtils.toString(responseEntity);
                logger.info("响应内容:{}", result);
                return result;
            }
        } catch (Exception e) {
            logger.error("url:{} post请求出错:{}", url, e);
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
                logger.error("url:{} post关闭连接异常:{}", url, e);
            }
        }
        return null;
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
