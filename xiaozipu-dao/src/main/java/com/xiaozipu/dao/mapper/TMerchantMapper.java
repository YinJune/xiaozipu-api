package com.xiaozipu.dao.mapper;

import com.xiaozipu.dao.entity.TMerchant;
import com.xiaozipu.dao.entity.TMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMerchantMapper {
    long countByExample(TMerchantExample example);

    int deleteByExample(TMerchantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMerchant record);

    int insertSelective(TMerchant record);

    List<TMerchant> selectByExample(TMerchantExample example);

    TMerchant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMerchant record, @Param("example") TMerchantExample example);

    int updateByExample(@Param("record") TMerchant record, @Param("example") TMerchantExample example);

    int updateByPrimaryKeySelective(TMerchant record);

    int updateByPrimaryKey(TMerchant record);

    int batchInsert(@Param("list") List<TMerchant> list);

    int batchInsertSelective(@Param("list") List<TMerchant> list, @Param("selective") TMerchant.Column ... selective);
}