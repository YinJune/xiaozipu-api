package com.xiaozipu.service.user;

import com.xiaozipu.dao.entity.generator.TUser;
import com.xiaozipu.dao.entity.generator.TUserExample;
import com.xiaozipu.dao.mapper.generator.TUserMapper;
import com.xiaozipu.service.constants.RedisKeyConstants;
import com.xiaozipu.service.enums.StatusEnum;
import com.xiaozipu.service.pojo.dto.CaptchaLoginDto;
import com.xiaozipu.service.util.JwtUtils;
import com.xiaozipu.service.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 20:11
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private TUserMapper userMapper;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 验证码登陆
     *
     * @param captchaLoginDto
     * @return
     */
    @Override
    public String loginCaptcha(CaptchaLoginDto captchaLoginDto) {
        TUser user = getUserByPhone(captchaLoginDto.getPhone());
        if (user == null) {
            //注册
            user=saveUser(captchaLoginDto.getPhone());
        }
        Integer userId=user.getId();
        String token=JwtUtils.generateToken(userId);
        redisUtils.set(RedisKeyConstants.USER_TOKEN+userId,token,JwtUtils.EXPIRATION);
        return token;
    }

    /**
     * 根据手机号注册用户
     *
     * @param phone
     */
    @Transactional(rollbackFor = Exception.class)
    public TUser saveUser(String phone) {
        TUser user=new TUser();
        user.setPhone(phone);
        user.setNickName(phone);
        user.setStatus(StatusEnum.VALID.getKey());
        userMapper.insertSelective(user);
        return user;
    }

    /**
     * 根据手机号查询用户
     *
     * @param phone
     * @return
     */
    @Override
    public TUser getUserByPhone(String phone) {
        TUserExample userExample = new TUserExample();
        userExample.createCriteria().andPhoneEqualTo(phone).andStatusEqualTo(StatusEnum.VALID.getKey());
        List<TUser> userList = userMapper.selectByExample(userExample);
        if (!CollectionUtils.isEmpty(userList)) {
            return userList.get(0);
        }
        return null;
    }
}
