package com.xiaozipu.client.config;

import com.aliyun.oss.common.utils.HttpUtil;
import com.xiaozipu.client.service.wx.pay.*;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
        String key="";
        key=environment.getProperty("wechat.pay.key");
//        if ("prod".equals(environment.getProperty("spring.profiles.active"))){
//            key=environment.getProperty("wechat.pay.key");
//        }else {
//
//            try {
//                key=getSignKey();
//            } catch (Exception e) {
//                logger.error("获取沙箱key异常:{}",e);
//                throw new BusinessRuntimeException("","获取沙箱key异常");
//            }
//        }
        return key;
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



    public  String getSignKey() throws Exception {
        String nonce_str = WXPayUtil.generateNonceStr();//生成随机字符
        Map<String, String> param = new HashMap<String, String>();
        param.put("mch_id", "1582615011");//需要真实商户号
        param.put("nonce_str", nonce_str);//随机字符
        String sign = WXPayUtil.generateSignature(param,"03447810be8fc1d58d64eb9ea3a73cc0", WXPayConstants.SignType.MD5);//通过SDK生成签名其中API_KEY为商户对应的真实密钥
        param.put("sign", sign);
        String xml = WXPayUtil.mapToXml(param);//将map转换为xml格式
        String url = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";//沙箱密钥获取api
        String SignKey =  HttpUtils.sendXMLDataByPost(url,xml);
        Map<String, String> param1 = new HashMap<String, String>();
        param1 = WXPayUtil.xmlToMap(SignKey);
        String key = param1.get("sandbox_signkey");
        return key;
    }

}
