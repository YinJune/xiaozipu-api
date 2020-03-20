package com.xiaozipu.merchant.service.merchant;

import com.xiaozipu.common.util.MD5Utils;
import com.xiaozipu.dao.entity.generator.TMerchant;
import com.xiaozipu.dao.mapper.generator.TMerchantMapper;
import com.xiaozipu.merchant.pojo.dto.merchant.RegisterDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

}
