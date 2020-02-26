package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TProductSpec;
import com.xiaozipu.dao.entity.generator.TProductSpecExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TProductSpecMapper {
    long countByExample(TProductSpecExample example);

    int deleteByExample(TProductSpecExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProductSpec record);

    int insertSelective(TProductSpec record);

    List<TProductSpec> selectByExample(TProductSpecExample example);

    TProductSpec selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProductSpec record, @Param("example") TProductSpecExample example);

    int updateByExample(@Param("record") TProductSpec record, @Param("example") TProductSpecExample example);

    int updateByPrimaryKeySelective(TProductSpec record);

    int updateByPrimaryKey(TProductSpec record);

    int batchInsert(@Param("list") List<TProductSpec> list);

    int batchInsertSelective(@Param("list") List<TProductSpec> list, @Param("selective") TProductSpec.Column... selective);
}