package com.xiaozipu.client.service.cart;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.client.dao.entity.CartProductDO;
import com.xiaozipu.client.dao.mapper.ShoppingCartDao;
import com.xiaozipu.client.pojo.dto.AddCartDTO;
import com.xiaozipu.client.pojo.dto.DeleteCartDTO;

import com.xiaozipu.dao.entity.TShoppingCartProduct;
import com.xiaozipu.dao.entity.TShoppingCartProductExample;
import com.xiaozipu.dao.mapper.TShoppingCartProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    @Resource
    private ShoppingCartDao shoppingCartDao;

    /**
     * 根据商品id查询购物车记录
     *
     * @param productSpecId 商品规格id
     * @return
     */
    @Override
    public TShoppingCartProduct getUserCartProduct(Integer userId,Integer productSpecId) {
        TShoppingCartProductExample example = new TShoppingCartProductExample();
        example.createCriteria().andUserIdEqualTo(userId).andProductSpecIdEqualTo(productSpecId);
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
        TShoppingCartProduct cartProduct = getUserCartProduct(userId,addCartDTO.getProductSpecId());
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
    public List<CartProductDO> getCartProducts(Integer userId, Integer currentPage) {
        PageHelper.startPage(currentPage, 10);
        List<CartProductDO> cartProductVOS = shoppingCartDao.getCartProducts(userId);
        return cartProductVOS;
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

    /**
     * 计算购物车金额
     *
     * @param cartIds
     * @return
     */
    @Override
    public BigDecimal calculateAmount(List<Integer> cartIds) {
        BigDecimal orderAmount=shoppingCartDao.calculateAmount(cartIds);
        return orderAmount;
    }

    /**
     * @param cartIds
     * @return
     */
    @Override
    public List<CartProductDO> batchGetProductSummary(List<Integer> cartIds) {
        return shoppingCartDao.batchGetProductSummary(cartIds);
    }
}
