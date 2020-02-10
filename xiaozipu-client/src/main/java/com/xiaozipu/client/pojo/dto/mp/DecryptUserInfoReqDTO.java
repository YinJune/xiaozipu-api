package com.xiaozipu.client.pojo.dto.mp;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/10 11:49
 * @description:
 */
@Data
public class DecryptUserInfoReqDTO {
    /**
     * 加密数据
     */
    private String encryptedData;
    /**
     * openid
     */
    private String openId;
    /**
     * iv
     */
    private String iv;
}
