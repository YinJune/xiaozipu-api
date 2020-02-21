package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TShoppingCart;
import com.xiaozipu.dao.entity.generator.TShoppingCartExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TShoppingCartMapper {
    long countByExample(TShoppingCartExample example);

    int deleteByExample(TShoppingCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TShoppingCart record);

    int insertSelective(TShoppingCart record);

    List<TShoppingCart> selectByExample(TShoppingCartExample example);

    TShoppingCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TShoppingCart record, @Param("example") TShoppingCartExample example);

    int updateByExample(@Param("record") TShoppingCart record, @Param("example") TShoppingCartExample example);

    int updateByPrimaryKeySelective(TShoppingCart record);

    int updateByPrimaryKey(TShoppingCart record);

    int batchInsert(@Param("list") List<TShoppingCart> list);

    int batchInsertSelective(@Param("list") List<TShoppingCart> list, @Param("selective") TShoppingCart.Column... selective);
}