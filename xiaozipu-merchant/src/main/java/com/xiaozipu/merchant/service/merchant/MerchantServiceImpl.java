package com.xiaozipu.merchant.service.merchant;

import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.util.MD5Utils;
import com.xiaozipu.dao.entity.generator.TMerchant;
import com.xiaozipu.dao.entity.generator.TMerchantExample;
import com.xiaozipu.dao.mapper.generator.TMerchantMapper;
import com.xiaozipu.merchant.pojo.dto.merchant.RegisterDTO;
import com.xiaozipu.merchant.util.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author: YinJunJie
 * @date: 2020/3/19 23:03
 * @description:
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    @Resource
    private TMerchantMapper merchantMapper;

    /**
     * 注册
     *
     * @param registerDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(RegisterDTO registerDTO) throws Exception {
        TMerchant merchant = new TMerchant();
        merchant.setPhone(registerDTO.getPhone());
        merchant.setName(registerDTO.getName());
        String salt = MD5Utils.MD5(registerDTO.getPhone() + UUID.randomUUID().toString());
        merchant.setSalt(salt);
        merchant.setPassword(MD5Utils.MD5(registerDTO.getPassword() + salt));
        merchantMapper.insertSelective(merchant);
    }

    /**
     * 登陆
     *
     * @param registerDTO
     * @return
     */
    @Override
    public String login(RegisterDTO registerDTO) {
        TMerchantExample example = new TMerchantExample();
        example.createCriteria().andPhoneEqualTo(registerDTO.getPassword());
        List<TMerchant> merchantList = merchantMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(merchantList)) {
            throw new BusinessRuntimeException("", "用户名错误");
        }
        TMerchant merchant = merchantList.get(0);
        String encodePassword = MD5Utils.MD5(registerDTO.getPassword() + merchant.getSalt());
        if (!merchant.getPassword().equals(encodePassword)) {
            throw new BusinessRuntimeException("", "密码错误");
        }
        String token = JwtUtils.generateToken(merchant.getId(), merchant.getPhone());
        return token;
    }

}
