package com.xiaozipu.client.service.sms;

import com.xiaozipu.client.common.constants.RedisKeyConstants;
import com.xiaozipu.client.enums.aliyun.SmsTypeEnum;
import com.xiaozipu.client.util.RedisUtils;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.third.service.sms.AliyunSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/2/9 22:10
 * @description:
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private AliyunSmsService aliyunSmsService;
    @Autowired
    private RedisUtils redisUtils;
    private static final int timesLimit = 20;

    /**
     * 发送短信
     *
     * @param type
     * @param phone
     */
    @Override
    public void sendSms(String type, String phone) {
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        Map map = new HashMap();
        map.put("code", random);
        String code = SmsTypeEnum.getCodeByType(type);
        aliyunSmsService.sendSms(code, phone, map);
        redisUtils.set(RedisKeyConstants.USER_TOKEN + type + ":" + phone, random + "", 300L);
        String timesKey = RedisKeyConstants.SEND_CAPTCHA_TIMES + type + ":" + phone;
        String times = redisUtils.get(timesKey);
        if ((!StringUtils.isEmpty(times)) && timesLimit >= Integer.parseInt(times)) {
            throw new BusinessRuntimeException("", "短信超出限制");
        }
        redisUtils.incr(timesKey, 1);
        redisUtils.expire(timesKey, redisUtils.getSecondsNextEarlyMorning());
    }
}
