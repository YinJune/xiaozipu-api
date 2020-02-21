package com.xiaozipu.client.service.cart;

import com.xiaozipu.dao.mapper.generator.TShoppingCartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 23:10
 * @description:
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private TShoppingCartMapper cartMapper;
}
