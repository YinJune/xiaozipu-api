package com.xiaozipu.client.service.user;

import com.xiaozipu.client.constants.RedisKeyConstants;
import com.xiaozipu.client.enums.StatusEnum;
import com.xiaozipu.client.pojo.dto.CaptchaLoginDTO;
import com.xiaozipu.client.pojo.dto.user.ThirdRegisterReqDTO;
import com.xiaozipu.client.util.JwtUtils;
import com.xiaozipu.client.util.RedisUtils;
import com.xiaozipu.dao.entity.generator.TUser;
import com.xiaozipu.dao.entity.generator.TUserExample;
import com.xiaozipu.dao.entity.generator.TUserThird;
import com.xiaozipu.dao.entity.generator.TUserThirdExample;
import com.xiaozipu.dao.mapper.generator.TUserMapper;
import com.xiaozipu.dao.mapper.generator.TUserThirdMapper;
import org.springframework.beans.BeanUtils;
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
    @Resource
    private TUserThirdMapper userThirdMapper;

    /**
     * 验证码登陆
     *
     * @param captchaLoginDto
     * @return
     */
    @Override
    public String loginCaptcha(CaptchaLoginDTO captchaLoginDto) {
        TUser user = getUserByPhone(captchaLoginDto.getPhone());
        if (user == null) {
            //注册
            user=saveUser(captchaLoginDto.getPhone());
        }
        Integer userId=user.getId();
        String token=JwtUtils.generateToken(userId,user.getPhone());
        redisUtils.set(RedisKeyConstants.USER_TOKEN+userId,token, JwtUtils.EXPIRATION);
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

    /**
     * 第三方注册
     *
     * @param thirdRegisterReqDTO
     * @return
     */
    @Override
    public String thirdRegister(ThirdRegisterReqDTO thirdRegisterReqDTO) {
        TUser user=new TUser();
        BeanUtils.copyProperties(thirdRegisterReqDTO,user);
        user.setStatus(StatusEnum.VALID.getKey());
        userMapper.insertSelective(user);
        TUserThird userThird=new TUserThird();
        BeanUtils.copyProperties(thirdRegisterReqDTO,userThird);
        userThird.setUserId(user.getId());
        //现没有unionid
        userThird.setOpenId(thirdRegisterReqDTO.getUniqueId());
        String token=JwtUtils.generateToken(user.getId(),user.getPhone());
        return token;
    }

    /**
     * 是否已注册
     *
     * @param thirdUniqueId
     * @return
     */
    @Override
    public boolean thirdExists(String thirdUniqueId) {
        TUserThirdExample example=new TUserThirdExample();
        example.createCriteria().andThirdUniqueIdEqualTo(thirdUniqueId);
        long count=userThirdMapper.countByExample(example);
        return count!=0;
    }
}
