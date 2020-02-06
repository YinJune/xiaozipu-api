package com.xiaozipu.third.service;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.util.HttpUtils;
import com.xiaozipu.third.config.WxConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: YinJunJie
 * @date: 2020/2/6 10:56
 * @description:
 */
@Service
public class MpServiceImpl implements MpService {
    private static Logger logger= LoggerFactory.getLogger(MpServiceImpl.class);

    private static final String MINI_LOGIN_URL="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    @Autowired
    private WxConfig wxConfig;

    /**
     * 小程序登陆
     *
     * @param jsCode
     * @return
     */
    @Override
    public JSONObject miniLogin(String jsCode) {
        String url=MINI_LOGIN_URL.replace("APPID",wxConfig.getAppId()).replace("SECRET",wxConfig.getSecret());
        try {
            String result= HttpUtils.getForResult(url);
            return JSONObject.parseObject(result);
        } catch (Exception e) {
            logger.error("微信小程序登陆异常：{}",e);
            //TODO 异常
            throw new BusinessRuntimeException("","");
        }
    }

    /**
     * 解密用户信息
     */
    @Override
    public void decryptMpData(String encryptedData) {

    }
}
