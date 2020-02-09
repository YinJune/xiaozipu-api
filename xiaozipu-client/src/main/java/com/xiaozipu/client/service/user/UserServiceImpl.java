package com.xiaozipu.client.service.user;

import com.xiaozipu.client.constants.RedisKeyConstants;
import com.xiaozipu.client.enums.StatusEnum;
import com.xiaozipu.client.enums.aliyun.SmsTypeEnum;
import com.xiaozipu.client.pojo.dto.CaptchaLoginDTO;
import com.xiaozipu.client.pojo.dto.user.ThirdRegisterReqDTO;
import com.xiaozipu.client.util.JwtUtils;
import com.xiaozipu.client.util.RedisUtils;
import com.xiaozipu.common.exception.BusinessRuntimeException;
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
        //校验验证码
        String captcha = (String) redisUtils.get(RedisKeyConstants.USER_CAPTCHA + SmsTypeEnum.LOGIN.getType() + ":" + captchaLoginDto.getPhone());
        if (!captchaLoginDto.getCaptcha().equals(captcha)) {

            throw new BusinessRuntimeException("", "");//TODO
        }
        TUser user = getUserByPhone(captchaLoginDto.getPhone());
        if (user == null) {
            //注册
            user = saveUser(captchaLoginDto.getPhone());
        }
        Integer userId = user.getId();
        String token = JwtUtils.generateToken(userId, user.getPhone());
        redisUtils.set(RedisKeyConstants.USER_TOKEN + userId, token, JwtUtils.EXPIRATION);
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
        //先查询手机号是否在user表中存在（有可能在h5渠道注册）
        TUser user=getUserByPhone(thirdRegisterReqDTO.getPhone());
        //不为空表示该手机号已注册，但没有绑定第三方账号 只需要绑定一下
        //支付宝用户和微信用户同用1个手机号，已绑定过微信，则只绑定支付宝，信息仍为首次绑定的信息
        if (user==null){
            user=new TUser();
            BeanUtils.copyProperties(thirdRegisterReqDTO,user);
            user.setStatus(StatusEnum.VALID.getKey());
            userMapper.insertSelective(user);
        }
        TUserThird userThird=new TUserThird();
        BeanUtils.copyProperties(thirdRegisterReqDTO,userThird);
        userThird.setUserId(user.getId());
        //现没有unionid
        userThird.setOpenId(thirdRegisterReqDTO.getUniqueId());
        userThirdMapper.insertSelective(userThird);
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
    public TUser findUserByThirdUniqueId(String thirdUniqueId) {
        TUserThirdExample example=new TUserThirdExample();
        example.createCriteria().andThirdUniqueIdEqualTo(thirdUniqueId);
        List<TUserThird> userThirds=userThirdMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userThirds)){
            return null;
        }
        TUser user=findUserById(userThirds.get(0).getUserId());
        return user;
    }

    @Override
    public TUser findUserById(Integer userId) {

        return userMapper.selectByPrimaryKey(userId);
    }
}
