package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TProduct;
import com.xiaozipu.dao.entity.generator.TProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int countByExample(TProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int deleteByExample(TProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int insert(TProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int insertSelective(TProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    List<TProduct> selectByExample(TProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    TProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TProduct record, @Param("example") TProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TProduct record, @Param("example") TProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TProduct record);
}