package com.xiaozipu.client.pojo.dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author: YinJunJie
 * @date: 2020/2/7 10:36
 * @description:
 */
@Data
public class ThirdRegisterReqDTO {
    /**
     * 唯一id
     */
//    @NotEmpty(message = "uniqueId不能为空")
    private String uniqueId;
    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    /**
     * 注册渠道
     */
    @NotEmpty(message = "注册渠道不能为空")
    private String type;
    /**
     * 性别
     */
    @NotEmpty(message = "性别不能为空")
    private String gender;
    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空")
    private String nickName;
    /**
     * 头像
     */
    @NotEmpty(message = "头像不能为空")
    private String avatarUrl;

    /**
     * openId
     */
    private String openId;
}
