package com.xiaozipu.client.config;

import com.xiaozipu.client.service.wx.pay.IWXPayDomain;
import com.xiaozipu.client.service.wx.pay.WXPayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @author: YinJunJie
 * @date: 2020/3/26 16:13
 * @description:
 */
@Component
public class MyWXPayConfig extends WXPayConfig implements   EnvironmentAware {

    private Environment environment;

    private static final Logger logger= LoggerFactory.getLogger(MyWXPayConfig.class);

    @Override
    protected String getAppID() {
        return environment.getProperty("wechat.mp.appId");
    }

    @Override
    protected String getMchID() {
        return environment.getProperty("wechat.pay.mchId");
    }

    @Override
    protected String getKey() {
        return environment.getProperty("wechat.pay.key");
    }

    @Override
    protected InputStream getCertStream() {
        return null;
    }

    @Override
    protected IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
                if (ex!=null){
                    logger.error("请求微信支付异常:{}",ex);
                }
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo(environment.getProperty("wechat.pay.domain"),true);
            }
        };
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }
}
