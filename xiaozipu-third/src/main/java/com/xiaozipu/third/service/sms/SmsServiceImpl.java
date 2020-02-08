package com.xiaozipu.third.service.sms;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 17:37
 * @description:
 */
@Service
public class SmsServiceImpl implements SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    private static final String domainName="dysmsapi.aliyuncs.com";
    @Value("${aliyun.sms.access-key-secret}")
    private String accessKeySecret;
    @Value("${aliyun.sms.access-key}")
    private String accessKey;
    private static final String region="cn-hangzhou";
    private static final String version="2017-05-25";
    private static final String signName="小资街";

    private static final String action="SendSms";

    /**
     * 发送短信
     *
     * @param code
     */
    @Override
    public void sendSms(String code,String phone, Map paramMap) {
        DefaultProfile profile = DefaultProfile.getProfile(region, accessKey, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domainName);
        request.setVersion(version);
        request.setAction(action);
        request.putQueryParameter("RegionId", region);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", code);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(paramMap));
//        request.putQueryParameter("OutId", "11111");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            logger.info("阿里云短息返回：{}", JSONObject.toJSONString(response));
        } catch (ClientException e) {
            logger.error("发送短信异常");
            throw new BusinessRuntimeException("","");
        }
    }
}
