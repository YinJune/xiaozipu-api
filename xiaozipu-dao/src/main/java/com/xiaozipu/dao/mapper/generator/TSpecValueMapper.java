package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TSpecValue;
import com.xiaozipu.dao.entity.generator.TSpecValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpecValueMapper {
    long countByExample(TSpecValueExample example);

    int deleteByExample(TSpecValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSpecValue record);

    int insertSelective(TSpecValue record);

    List<TSpecValue> selectByExample(TSpecValueExample example);

    TSpecValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSpecValue record, @Param("example") TSpecValueExample example);

    int updateByExample(@Param("record") TSpecValue record, @Param("example") TSpecValueExample example);

    int updateByPrimaryKeySelective(TSpecValue record);

    int updateByPrimaryKey(TSpecValue record);

    int batchInsert(@Param("list") List<TSpecValue> list);

    int batchInsertSelective(@Param("list") List<TSpecValue> list, @Param("selective") TSpecValue.Column ... selective);
}