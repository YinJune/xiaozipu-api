package com.xiaozipu.client.service.alipay;

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
}
