package com.xiaozipu.client.dao.mapper;

import com.xiaozipu.client.dao.entity.CartProductDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 20:12
 * @description:
 */
public interface ShoppingCartDao {
    /**
     * 查询购物车列表
     *
     * @param userId
     * @return
     */
    List<CartProductDO> getCartProducts(@Param("userId") Integer userId);

    /**
     * @param cartId
     * @return
     */
    BigDecimal calculateAmount(@Param("cartIds") List<Integer> cartId);

    /**
     * 获取确认订单页商品列表信息
     *
     * @param cartIds
     * @return
     */
    List<CartProductDO> batchGetProductSummary(@Param("cartIds") List<Integer> cartIds);
}
