package com.xiaozipu.service.sms;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.service.pojo.dto.sms.SendSmsReqDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 17:37
 * @description:
 */
@Service
public class SmsServiceImpl implements SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Value("${aliyun.sms.domain-name}")
    private String domainName;
    @Value("${aliyun.sms.access-key-secret}")
    private String accessKeySecret;
    @Value("${aliyun.sms.access-key}")
    private String accessKey;
    @Value("${aliyun.sms.region}")
    private String region;
    @Value("${aliyun.sms.version}")
    private String version;

    private static final String action="SendSms";

    /**
     * 发送短信
     *
     * @param sendSmsReqDTO
     */
    @Override
    public void sendSms(SendSmsReqDTO sendSmsReqDTO) {
        DefaultProfile profile = DefaultProfile.getProfile(region, accessKey, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domainName);
        request.setVersion(version);
        request.setAction(action);
        request.putQueryParameter("RegionId", region);
        request.putQueryParameter("PhoneNumbers", sendSmsReqDTO.getPhone());
        request.putQueryParameter("SignName", "小资街");
        request.putQueryParameter("TemplateCode", "SMS_181740307");
        request.putQueryParameter("TemplateParam", "123456");
        request.putQueryParameter("OutId", "111");
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
