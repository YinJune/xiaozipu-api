package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.TBanner;
import com.xiaozipu.dao.entity.TBannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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