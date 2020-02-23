package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.pojo.dto.AddCartDTO;
import com.xiaozipu.client.pojo.dto.DeleteCartDTO;
import com.xiaozipu.client.pojo.vo.product.CartProductVO;
import com.xiaozipu.client.service.cart.ShoppingCartService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.dao.entity.generator.TShoppingCartProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public ResultInfo addToCart(HttpServletRequest request, @RequestBody @Validated AddCartDTO addCartDTO) {
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("添加购物车:{}", JSONObject.toJSONString(addCartDTO));
        ResultInfo resultInfo = new ResultInfo();
        shoppingCartService.addToCart(userId, addCartDTO);
        return resultInfo;
    }

    /**
     * 购物车商品列表
     */
    @GetMapping("/shopping/cart/list")
    public ResultInfo getCartProducts(HttpServletRequest request, @RequestParam("currentPage") Integer currentPage) {
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("购物车商品列表:{}", userId);
        ResultInfo resultInfo = new ResultInfo();
        List<TShoppingCartProduct> products = shoppingCartService.getCartProducts(userId, currentPage);
        List<CartProductVO> productVOS = BeanCopyUtils.copyListProperties(products, CartProductVO::new);
        resultInfo.setData(productVOS);
        return resultInfo;
    }

    /**
     * 删除购物车
     *
     * @param request
     * @param deleteCartDTO
     * @return
     */
    @PostMapping("/shopping/cart/delete")
    public ResultInfo deleteCartProducts(HttpServletRequest request, @RequestBody DeleteCartDTO deleteCartDTO) {
        ResultInfo resultInfo = new ResultInfo();
        logger.info("删除购物车商品:{}", JSONObject.toJSONString(deleteCartDTO));
        shoppingCartService.deleteProducts(deleteCartDTO);
        return resultInfo;
    }
}
