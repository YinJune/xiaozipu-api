package com.xiaozipu.client.web;

import com.xiaozipu.client.service.cart.ShoppingCartService;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 23:07
 * @description: 购物车
 */
@RestController
public class ShoppingCartController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     *
     * @return
     */
    @PostMapping("/shopping/cart/add")
    public ResultInfo addProduct() {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }
}
