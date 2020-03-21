package com.xiaozipu.client.service.mp;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.config.WxConfig;
import com.xiaozipu.client.constants.RedisKeyConstants;
import com.xiaozipu.client.pojo.dto.mp.DecryptUserInfoReqDTO;
import com.xiaozipu.client.pojo.dto.mp.MpLoginResDTO;
import com.xiaozipu.client.service.user.UserService;
import com.xiaozipu.client.util.JwtUtils;
import com.xiaozipu.client.util.RedisUtils;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.util.HttpUtils;
import com.xiaozipu.dao.entity.TUser;
import com.xiaozipu.third.util.mp.MpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author: YinJunJie
 * @date: 2020/2/6 10:56
 * @description:
 */
@Service
public class MpServiceImpl implements MpService {
    private static Logger logger = LoggerFactory.getLogger(MpServiceImpl.class);
    private static final String MINI_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
    private static final String LOGIN_SUCCESS = "0";
    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 小程序登陆
     *
     * @param jsCode
     * @return
     */
    @Override
    public MpLoginResDTO miniLogin(String jsCode) {
        String url = MINI_LOGIN_URL.replace("APPID", wxConfig.getAppId()).replace("SECRET", wxConfig.getSecret()).replace("JSCODE", jsCode);
        try {
            String result = HttpUtils.getForResult(url);
            JSONObject jsonObject = JSONObject.parseObject(result);
//            if (!LOGIN_SUCCESS.equals(jsonObject.getString("errcode"))){
//                logger.error("小程序登陆出错:{}",jsonObject);
//                throw new BusinessRuntimeException("","小程序登陆异常");
//            }
            String openId = jsonObject.getString("openid");
            MpLoginResDTO mpLoginResDTO = new MpLoginResDTO();
            mpLoginResDTO.setOpenId(openId);
            String sessionKey = jsonObject.getString("session_key");
            if (StringUtils.isEmpty(openId)) {
                logger.error("小程序登陆出错:{}", jsonObject);
                throw new BusinessRuntimeException("", "小程序登陆异常");
            }
            //过期时间微信不告知，前端可检查session_key是否过期
            redisUtils.set(RedisKeyConstants.MP_SESSION_KEY + openId, sessionKey);
            //第三方表中是否存在该用户
            TUser user = userService.findUserByThirdUniqueId(openId);
            //如果存在则必有手机号 返回token
            if (user != null) {
                String token = JwtUtils.generateToken(user.getId(), user.getPhone());
                jsonObject.put("token", token);
                redisUtils.set(RedisKeyConstants.USER_TOKEN + user.getId(), token, JwtUtils.EXPIRATION);
                mpLoginResDTO.setToken(token);
            }

            return mpLoginResDTO;
        } catch (Exception e) {
            logger.error("微信小程序登陆异常：{}", e);
            //TODO 异常
            throw new BusinessRuntimeException("", "小程序登陆异常");
        }
    }

    /**
     * 解密用户信息
     */
    @Override
    public JSONObject decryptData(DecryptUserInfoReqDTO decryptUserInfoReqDTO) {
        String sessionKey = redisUtils.get(RedisKeyConstants.MP_SESSION_KEY + decryptUserInfoReqDTO.getOpenId());
        String decryptData = MpUtils.decrypt(wxConfig.getAppId(), decryptUserInfoReqDTO.getEncryptedData(), sessionKey, decryptUserInfoReqDTO.getIv());
//        UserInfoVO userInfoVo = JSONObject.parseObject(decryptData).toJavaObject(UserInfoVO.class);
        //不是所有的解密数据都是userInfo 也不是所有的数据都需要保存
        return JSONObject.parseObject(decryptData);
    }
}
