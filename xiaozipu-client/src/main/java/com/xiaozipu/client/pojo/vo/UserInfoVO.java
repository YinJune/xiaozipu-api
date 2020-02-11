package com.xiaozipu.client.pojo.vo;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/10 11:45
 * @description:
 */
@Data
public class UserInfoVO {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 头像
     */
    private String avatarUrl;
}
