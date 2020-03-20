package com.xiaozipu.merchant.service.merchant;

import com.xiaozipu.merchant.pojo.dto.merchant.RegisterDTO;

/**
 * @author: YinJunJie
 * @date: 2020/3/19 23:03
 * @description:
 */
public interface MerchantService {
    /**
     * 注册
     * @param registerDTO
     */
    void register(RegisterDTO registerDTO) throws Exception;
}
