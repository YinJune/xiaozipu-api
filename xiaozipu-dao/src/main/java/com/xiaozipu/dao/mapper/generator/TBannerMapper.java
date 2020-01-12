package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TBanner;
import com.xiaozipu.dao.entity.generator.TBannerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBannerMapper {
    int countByExample(TBannerExample example);

    int deleteByExample(TBannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBanner record);

    int insertSelective(TBanner record);

    List<TBanner> selectByExample(TBannerExample example);

    TBanner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBanner record, @Param("example") TBannerExample example);

    int updateByExample(@Param("record") TBanner record, @Param("example") TBannerExample example);

    int updateByPrimaryKeySelective(TBanner record);

    int updateByPrimaryKey(TBanner record);
}