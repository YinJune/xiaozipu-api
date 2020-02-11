package com.xiaozipu.client.pojo.dto.mp;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "加密数据不能为空")
    private String encryptedData;
    /**
     * openid
     */
    @NotEmpty(message = "openId不能为空")
    private String openId;
    /**
     * iv
     */
    @NotEmpty(message = "iv不能为空")
    private String iv;
}
