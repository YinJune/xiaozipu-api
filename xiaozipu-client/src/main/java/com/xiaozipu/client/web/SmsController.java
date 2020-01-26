package com.xiaozipu.client.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.pojo.dto.sms.SendSmsReqDTO;
import com.xiaozipu.service.sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/1/23 17:34
 * @description:
 */
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    /**
     * 发送短信
     *
     * @param sendSmsReqDTO
     * @return
     */
    @PostMapping("/sms/send")
    public ResultInfo sendSms(@RequestBody SendSmsReqDTO sendSmsReqDTO) {
        ResultInfo resultInfo = new ResultInfo();
        Map map = new HashMap();
        map.put("code", (int) ((Math.random() * 9 + 1) * 100000));
        smsService.sendSms(sendSmsReqDTO, map);
        return resultInfo;
    }

}
