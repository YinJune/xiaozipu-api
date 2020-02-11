package com.xiaozipu.client.service.mp;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.pojo.dto.mp.DecryptUserInfoReqDTO;
import com.xiaozipu.client.pojo.dto.mp.MpLoginResDTO;

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
    MpLoginResDTO miniLogin(String jsCode);

    /**
     * 解密
     *
     * @param decryptUserInfoReqDTO
     * @return
     */
    JSONObject decryptData(DecryptUserInfoReqDTO decryptUserInfoReqDTO);
}
