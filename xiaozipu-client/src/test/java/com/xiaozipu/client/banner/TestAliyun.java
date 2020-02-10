package com.xiaozipu.client.banner;

import com.xiaozipu.client.pojo.dto.sms.SendSmsReqDTO;
import com.xiaozipu.third.service.sms.AliyunSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

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
    private AliyunSmsService aliyunSmsService;

    @Test
    public void testSendSms() {
        SendSmsReqDTO sendSmsReqDTO = new SendSmsReqDTO();
//        sendSmsReqDTO.setPhone("17513130886");
//        sendSmsReqDTO.setCode("SMS_181740306");
//        Map map = new HashMap();
//        map.put("code", "789456");//service改成参数多
//        aliyunSmsService.sendSms(sendSmsReqDTO.getCode(), sendSmsReqDTO.getPhone(), map);
    }
}
