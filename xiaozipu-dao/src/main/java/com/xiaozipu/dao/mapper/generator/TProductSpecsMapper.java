package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TProductSpecs;
import com.xiaozipu.dao.entity.generator.TProductSpecsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductSpecsMapper {
    long countByExample(TProductSpecsExample example);

    int deleteByExample(TProductSpecsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProductSpecs record);

    int insertSelective(TProductSpecs record);

    List<TProductSpecs> selectByExample(TProductSpecsExample example);

    TProductSpecs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProductSpecs record, @Param("example") TProductSpecsExample example);

    int updateByExample(@Param("record") TProductSpecs record, @Param("example") TProductSpecsExample example);

    int updateByPrimaryKeySelective(TProductSpecs record);

    int updateByPrimaryKey(TProductSpecs record);

    int batchInsert(@Param("list") List<TProductSpecs> list);

    int batchInsertSelective(@Param("list") List<TProductSpecs> list, @Param("selective") TProductSpecs.Column ... selective);
}