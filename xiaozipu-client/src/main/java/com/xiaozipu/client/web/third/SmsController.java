package com.xiaozipu.client.web.third;

import com.xiaozipu.client.pojo.dto.sms.SendSmsReqDTO;
import com.xiaozipu.client.service.sms.SmsService;
import com.xiaozipu.common.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/2/9 21:34
 * @description:
 */
@RestController
public class SmsController {
    @Autowired
    private SmsService smsService;

    /**
     * 发送验证码
     *
     * @param sendSmsReqDTO
     * @return
     */
    @PostMapping("/anon/aliyun/sms/send")
    public ResultInfo sendSms(@RequestBody SendSmsReqDTO sendSmsReqDTO) {
        ResultInfo resultInfo = new ResultInfo();
        smsService.sendSms(sendSmsReqDTO.getType(), sendSmsReqDTO.getPhone());
        return resultInfo;
    }
}
