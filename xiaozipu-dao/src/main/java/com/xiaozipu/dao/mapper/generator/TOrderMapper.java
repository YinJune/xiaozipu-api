package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TOrder;
import com.xiaozipu.dao.entity.generator.TOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderMapper {
    long countByExample(TOrderExample example);

    int deleteByExample(TOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    List<TOrder> selectByExample(TOrderExample example);

    TOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

    int batchInsert(@Param("list") List<TOrder> list);

    int batchInsertSelective(@Param("list") List<TOrder> list, @Param("selective") TOrder.Column... selective);
}