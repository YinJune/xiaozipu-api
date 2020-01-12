package com.xiaozipu.dao.mapper.generator;

import com.xiaozipu.dao.entity.generator.TRecommendProduct;
import com.xiaozipu.dao.entity.generator.TRecommendProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRecommendProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    long countByExample(TRecommendProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int deleteByExample(TRecommendProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int insert(TRecommendProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int insertSelective(TRecommendProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    List<TRecommendProduct> selectByExample(TRecommendProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    TRecommendProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TRecommendProduct record, @Param("example") TRecommendProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TRecommendProduct record, @Param("example") TRecommendProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TRecommendProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TRecommendProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int batchInsert(@Param("list") List<TRecommendProduct> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_recommend_product
     *
     * @mbg.generated
     */
    int batchInsertSelective(@Param("list") List<TRecommendProduct> list, @Param("selective") TRecommendProduct.Column ... selective);
}