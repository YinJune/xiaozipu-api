package com.xiaozipu.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/22 0:02
 */
@Component
@ConfigurationProperties(prefix = "wechat.mp")
public class WxConfig {
    private String appId;
    private String secret;
    private String mchId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }
}
