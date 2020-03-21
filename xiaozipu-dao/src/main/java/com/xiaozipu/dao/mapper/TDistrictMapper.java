package com.xiaozipu.dao.mapper;

import com.xiaozipu.dao.entity.TDistrict;
import com.xiaozipu.dao.entity.TDistrictExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TDistrictMapper {
    long countByExample(TDistrictExample example);

    int deleteByExample(TDistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDistrict record);

    int insertSelective(TDistrict record);

    List<TDistrict> selectByExample(TDistrictExample example);

    TDistrict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDistrict record, @Param("example") TDistrictExample example);

    int updateByExample(@Param("record") TDistrict record, @Param("example") TDistrictExample example);

    int updateByPrimaryKeySelective(TDistrict record);

    int updateByPrimaryKey(TDistrict record);

    int batchInsert(@Param("list") List<TDistrict> list);

    int batchInsertSelective(@Param("list") List<TDistrict> list, @Param("selective") TDistrict.Column... selective);
}