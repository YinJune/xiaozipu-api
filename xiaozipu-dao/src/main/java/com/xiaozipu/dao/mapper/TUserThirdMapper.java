package com.xiaozipu.dao.mapper;

import com.xiaozipu.dao.entity.TUserThird;
import com.xiaozipu.dao.entity.TUserThirdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserThirdMapper {
    long countByExample(TUserThirdExample example);

    int deleteByExample(TUserThirdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserThird record);

    int insertSelective(TUserThird record);

    TUserThird selectOneByExample(TUserThirdExample example);

    List<TUserThird> selectByExample(TUserThirdExample example);

    TUserThird selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserThird record, @Param("example") TUserThirdExample example);

    int updateByExample(@Param("record") TUserThird record, @Param("example") TUserThirdExample example);

    int updateByPrimaryKeySelective(TUserThird record);

    int updateByPrimaryKey(TUserThird record);

    int batchInsert(@Param("list") List<TUserThird> list);

    int batchInsertSelective(@Param("list") List<TUserThird> list, @Param("selective") TUserThird.Column ... selective);
}