package com.xiaozipu.client.pojo.dto.user;

import lombok.Data;

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
    private String uniqueId;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 注册渠道
     */
    private String type;
    /**
     * 性别
     */
    private String gender;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * 唯一id
     */
    private String thirdUniqueId;
}
