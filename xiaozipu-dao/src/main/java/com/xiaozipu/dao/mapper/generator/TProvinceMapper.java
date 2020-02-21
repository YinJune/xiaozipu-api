package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TProvince;
import com.xiaozipu.dao.entity.generator.TProvinceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TProvinceMapper {
    long countByExample(TProvinceExample example);

    int deleteByExample(TProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProvince record);

    int insertSelective(TProvince record);

    List<TProvince> selectByExample(TProvinceExample example);

    TProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProvince record, @Param("example") TProvinceExample example);

    int updateByExample(@Param("record") TProvince record, @Param("example") TProvinceExample example);

    int updateByPrimaryKeySelective(TProvince record);

    int updateByPrimaryKey(TProvince record);

    int batchInsert(@Param("list") List<TProvince> list);

    int batchInsertSelective(@Param("list") List<TProvince> list, @Param("selective") TProvince.Column... selective);
}