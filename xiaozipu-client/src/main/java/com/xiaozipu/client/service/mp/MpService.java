package com.xiaozipu.client.service.mp;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: YinJunJie
 * @date: 2020/2/6 10:55
 * @description:
 */
public interface MpService {
    /**
     * 小程序登陆
     *
     * @param jsCode
     * @return
     */
    JSONObject miniLogin(String jsCode);

    /**
     * 解密用户信息
     */
    void decryptMpData(String encryptedData);
}
