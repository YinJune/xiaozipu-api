package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TOrderProduct;
import com.xiaozipu.dao.entity.generator.TOrderProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderProductMapper {
    long countByExample(TOrderProductExample example);

    int deleteByExample(TOrderProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TOrderProduct record);

    int insertSelective(TOrderProduct record);

    List<TOrderProduct> selectByExample(TOrderProductExample example);

    TOrderProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TOrderProduct record, @Param("example") TOrderProductExample example);

    int updateByExample(@Param("record") TOrderProduct record, @Param("example") TOrderProductExample example);

    int updateByPrimaryKeySelective(TOrderProduct record);

    int updateByPrimaryKey(TOrderProduct record);

    int batchInsert(@Param("list") List<TOrderProduct> list);

    int batchInsertSelective(@Param("list") List<TOrderProduct> list, @Param("selective") TOrderProduct.Column... selective);
}