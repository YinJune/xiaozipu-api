package com.xiaozipu.client.service.cart;

import com.xiaozipu.client.pojo.dto.AddCartDTO;
import com.xiaozipu.client.pojo.dto.DeleteCartDTO;
import com.xiaozipu.dao.entity.custom.CartProductDO;
import com.xiaozipu.dao.entity.generator.TShoppingCartProduct;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 23:10
 * @description:
 */
public interface ShoppingCartService {
    /**
     * 根据商品id查询购物车记录
     *
     * @param productSpecId 商品id
     * @return
     */
    TShoppingCartProduct getCartProductByProductId(Integer productSpecId);

    /**
     * 添加购物车
     *
     * @param userId
     * @param addCartDTO
     */
    void addToCart(Integer userId, AddCartDTO addCartDTO);

    /**
     * 购物车商品列表
     *
     * @param userId
     * @return
     */
    List<CartProductDO> getCartProducts(Integer userId, Integer currentPage);

    /**
     * 删除购物车商品
     *
     * @param deleteCartDTO
     */
    void deleteProducts(DeleteCartDTO deleteCartDTO);
}
