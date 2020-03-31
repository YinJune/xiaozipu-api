package com.xiaozipu.client.service.cart;

import com.xiaozipu.client.dao.entity.CartProductDO;
import com.xiaozipu.client.pojo.dto.AddCartDTO;
import com.xiaozipu.client.pojo.dto.DeleteCartDTO;
import com.xiaozipu.dao.entity.TShoppingCartProduct;

import java.math.BigDecimal;
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
    TShoppingCartProduct getUserCartProduct(Integer userId, Integer productSpecId);

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

    /**
     * 计算购物车金额
     *
     * @param cartId
     * @return
     */
    BigDecimal calculateAmount(List<Integer> cartId);

    /**
     * @param cartIds
     * @return
     */
    List<CartProductDO> batchGetProductSummary(List<Integer> cartIds);

    /**
     * 根据id查询cart
     *
     * @param cartId
     * @return
     */
    TShoppingCartProduct getById(Integer cartId);

    /**
     * 批量获取根据id
     *
     * @param cartIds
     * @return
     */
    List<TShoppingCartProduct> listByIds(List<Integer> cartIds);
}
