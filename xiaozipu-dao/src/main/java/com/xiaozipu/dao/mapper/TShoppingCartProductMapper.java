package com.xiaozipu.dao.mapper;

import com.xiaozipu.dao.entity.TShoppingCartProduct;
import com.xiaozipu.dao.entity.TShoppingCartProductExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TShoppingCartProductMapper {
    long countByExample(TShoppingCartProductExample example);

    int deleteByExample(TShoppingCartProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TShoppingCartProduct record);

    int insertSelective(TShoppingCartProduct record);

    List<TShoppingCartProduct> selectByExample(TShoppingCartProductExample example);

    TShoppingCartProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TShoppingCartProduct record, @Param("example") TShoppingCartProductExample example);

    int updateByExample(@Param("record") TShoppingCartProduct record, @Param("example") TShoppingCartProductExample example);

    int updateByPrimaryKeySelective(TShoppingCartProduct record);

    int updateByPrimaryKey(TShoppingCartProduct record);

    int batchInsert(@Param("list") List<TShoppingCartProduct> list);

    int batchInsertSelective(@Param("list") List<TShoppingCartProduct> list, @Param("selective") TShoppingCartProduct.Column... selective);
}