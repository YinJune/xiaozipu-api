package com.xiaozipu.client.service.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.xiaozipu.client.common.constants.RedisKeyConstants;
import com.xiaozipu.client.util.RedisUtils;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: YinJunJie
 * @date: 2020/3/25 10:14
 * @description:
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    private static final Logger logger = LoggerFactory.getLogger(AlipayServiceImpl.class);
    private static final String SERVER_URL = "https://openapi.alipay.com/gateway.do";
    private static final String APPID = "123456";
    private static final String PRIVATE_KEY = "123456";
    private static final String ALIPAY_PUBLIC_KEY = "123456";
    private static final String SCOPE = "userInfo";
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void auth(String authCode) {
        AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, "app_id", "your private_key", "json", "GBK", "alipay_public_key", "RSA2");
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(authCode);
        //刷新token 可选
//        request.setRefreshToken("201208134b203fe6c11548bcabd8da5bb087a83b");
        AlipaySystemOauthTokenResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.info("调用支付宝授权登录异常:{}", e);
            throw new BusinessRuntimeException("", "调用支付宝授权登录异常");
        }
        if (!response.isSuccess()) {
            logger.info("支付宝授权失败:{}", JSONObject.toJSONString(response));
            return;
        }
        logger.info("支付宝授权成功:{}", JSONObject.toJSONString(response));
        redisUtils.set(RedisKeyConstants.ALIPAY_ACCESS_TOKEN+APPID+response.getUserId()+SCOPE,response.getAccessToken(),60*60*2);

    }
}
