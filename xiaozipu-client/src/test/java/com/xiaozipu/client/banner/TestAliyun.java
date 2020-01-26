package com.xiaozipu.client.banner;

import com.xiaozipu.service.pojo.dto.sms.SendSmsReqDTO;
import com.xiaozipu.service.sms.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 18:40
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.xiaozipu"})
@MapperScan(basePackages = {"com.xiaozipu.dao.mapper"})
public class TestAliyun {

    @Autowired
    private SmsService smsService;

    @Test
    public void testSendSms() {
        SendSmsReqDTO sendSmsReqDTO = new SendSmsReqDTO();
        sendSmsReqDTO.setPhone("17513130886");
        sendSmsReqDTO.setCode("SMS_181740306");
        Map map = new HashMap();
        map.put("code", "789456");
        smsService.sendSms(sendSmsReqDTO.getCode(), sendSmsReqDTO.getPhone(), map);
    }
}
