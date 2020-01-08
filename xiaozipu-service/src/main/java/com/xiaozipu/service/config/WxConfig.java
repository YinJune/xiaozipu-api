package com.xiaozipu.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/22 0:02
 */
@Component
@ConfigurationProperties(prefix = "wx")
public class WxConfig {
    private String appId;
    private String secret;

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
}
