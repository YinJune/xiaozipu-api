package com.xiaozipu.client.service.alipay;

import com.alipay.api.response.AlipayUserInfoShareResponse;

/**
 * @author: YinJunJie
 * @date: 2020/3/25 10:14
 * @description:
 */
public interface AlipayService {
    /**
     * 支付宝授权
     *
     * @param authCode
     */
    void auth(String authCode);

    /**
     * 获取支付宝用户基础信息
     *
     * @param userId 支付宝的userId
     * @return
     */
    AlipayUserInfoShareResponse getAlipayUserInfo(String userId);
}
