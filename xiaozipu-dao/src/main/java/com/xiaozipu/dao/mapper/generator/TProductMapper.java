package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TProduct;
import com.xiaozipu.dao.entity.generator.TProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductMapper {
    long countByExample(TProductExample example);

    int deleteByExample(TProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    List<TProduct> selectByExampleWithBLOBs(TProductExample example);

    List<TProduct> selectByExample(TProductExample example);

    TProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByExampleWithBLOBs(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByExample(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKeyWithBLOBs(TProduct record);

    int updateByPrimaryKey(TProduct record);

    int batchInsert(@Param("list") List<TProduct> list);

    int batchInsertSelective(@Param("list") List<TProduct> list, @Param("selective") TProduct.Column... selective);
}