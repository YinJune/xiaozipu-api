package com.xiaozipu.client.service.user;

import com.xiaozipu.client.pojo.dto.CaptchaLoginDTO;
import com.xiaozipu.client.pojo.dto.user.ThirdRegisterReqDTO;
import com.xiaozipu.dao.entity.TUser;
import com.xiaozipu.dao.entity.TUserThird;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 20:10
 * @description:
 */
public interface UserService {
    /**
     * 验证码登陆
     *
     * @param captchaLoginDto
     * @return
     */
    String loginCaptcha(CaptchaLoginDTO captchaLoginDto);

    /**
     * 根据手机号查询用户
     *
     * @param phone
     * @return
     */
    TUser getUserByPhone(String phone);

    /**
     * 第三方注册
     *
     * @param thirdRegisterReqDTO
     * @return
     */
    String thirdRegister(ThirdRegisterReqDTO thirdRegisterReqDTO);

    /**
     * 是否已注册
     *
     * @param thirdUniqueId
     * @return
     */
    TUser findUserByThirdUniqueId(String thirdUniqueId);

    TUser findUserById(Integer userId);

    /**
     * 根据userId,type查询第三方账号
     *
     * @param userId
     * @return
     */
    TUserThird getUserThirdByType(Integer userId,String type);
}
