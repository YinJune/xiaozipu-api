package com.xiaozipu.client.dao.mapper;

import com.xiaozipu.dao.entity.custom.CartProductDO;
import org.apache.ibatis.annotations.Param;

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
}
