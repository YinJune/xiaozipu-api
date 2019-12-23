package com.xiaozipu.thirdapi.weixin.service;

import com.xiaozipu.thirdapi.weixin.dto.MiniLoginResDto;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/21 23:59
 */
public interface WeChatService {
    /**
     * 小程序登陆
     *
     * @param jsCode
     * @return
     */
    MiniLoginResDto miniLogin(String jsCode);

    /**
     * 解密用户信息
     */
    void decryptUserInfo();
}
