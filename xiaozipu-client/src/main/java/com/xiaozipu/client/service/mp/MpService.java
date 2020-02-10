package com.xiaozipu.client.service.mp;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.pojo.dto.mp.DecryptUserInfoReqDTO;
import com.xiaozipu.client.pojo.vo.UserInfoVo;

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
     * 解密
     *
     * @param decryptUserInfoReqDTO
     * @return
     */
    UserInfoVo decryptData(DecryptUserInfoReqDTO decryptUserInfoReqDTO);
}
