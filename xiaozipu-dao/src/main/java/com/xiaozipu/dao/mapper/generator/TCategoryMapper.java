package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TCategory;
import com.xiaozipu.dao.entity.generator.TCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCategoryMapper {
    long countByExample(TCategoryExample example);

    int deleteByExample(TCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCategory record);

    int insertSelective(TCategory record);

    List<TCategory> selectByExample(TCategoryExample example);

    TCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCategory record, @Param("example") TCategoryExample example);

    int updateByExample(@Param("record") TCategory record, @Param("example") TCategoryExample example);

    int updateByPrimaryKeySelective(TCategory record);

    int updateByPrimaryKey(TCategory record);

    int batchInsert(@Param("list") List<TCategory> list);

    int batchInsertSelective(@Param("list") List<TCategory> list, @Param("selective") TCategory.Column ... selective);
}