package com.xiaozipu.client.service.cart;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.client.pojo.dto.AddCartDTO;
import com.xiaozipu.client.pojo.dto.DeleteCartDTO;
import com.xiaozipu.dao.entity.generator.TShoppingCartProduct;
import com.xiaozipu.dao.entity.generator.TShoppingCartProductExample;
import com.xiaozipu.dao.mapper.generator.TShoppingCartProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 23:10
 * @description:
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private TShoppingCartProductMapper cartMapper;

    /**
     * 根据商品id查询购物车记录
     *
     * @param productSpecId 商品规格id
     * @return
     */
    @Override
    public TShoppingCartProduct getCartProductByProductId(Integer productSpecId) {
        TShoppingCartProductExample example = new TShoppingCartProductExample();
        example.createCriteria().andProductSpecIdEqualTo(productSpecId);
        List<TShoppingCartProduct> carts = cartMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(carts)) {
            return carts.get(0);
        }
        return null;
    }

    /**
     * 添加购物车
     *
     * @param userId
     * @param addCartDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addToCart(Integer userId, AddCartDTO addCartDTO) {
        TShoppingCartProduct cartProduct = getCartProductByProductId(addCartDTO.getProductSpecId());
        if (cartProduct == null) {
            //购物车中无该商品 新增
            cartProduct = new TShoppingCartProduct();
            cartProduct.setUserId(userId);
            cartProduct.setProductSpecId(addCartDTO.getProductSpecId());
            cartProduct.setQuantity(addCartDTO.getQuantity());
            cartMapper.insertSelective(cartProduct);
        } else {
            //购物车中已有该商品 直接改数量即可
            int quantity = cartProduct.getQuantity() + addCartDTO.getQuantity();
            cartProduct.setQuantity(quantity);
            cartMapper.updateByPrimaryKeySelective(cartProduct);
        }
    }

    /**
     * 购物车商品列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<TShoppingCartProduct> getCartProducts(Integer userId, Integer currentPage) {
        PageHelper.startPage(currentPage, 10);
        TShoppingCartProductExample example = new TShoppingCartProductExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return cartMapper.selectByExample(example);
    }

    /**
     * 删除购物车商品
     *
     * @param deleteCartDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteProducts(DeleteCartDTO deleteCartDTO) {
        for (Integer id : deleteCartDTO.getIds()) {
            cartMapper.deleteByPrimaryKey(id);
        }
    }

}
