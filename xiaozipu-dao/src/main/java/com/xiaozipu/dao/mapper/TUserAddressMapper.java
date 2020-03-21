package com.xiaozipu.dao.mapper;

import com.xiaozipu.dao.entity.TUserAddress;
import com.xiaozipu.dao.entity.TUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserAddressMapper {
    long countByExample(TUserAddressExample example);

    int deleteByExample(TUserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserAddress record);

    int insertSelective(TUserAddress record);

    List<TUserAddress> selectByExample(TUserAddressExample example);

    TUserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserAddress record, @Param("example") TUserAddressExample example);

    int updateByExample(@Param("record") TUserAddress record, @Param("example") TUserAddressExample example);

    int updateByPrimaryKeySelective(TUserAddress record);

    int updateByPrimaryKey(TUserAddress record);

    int batchInsert(@Param("list") List<TUserAddress> list);

    int batchInsertSelective(@Param("list") List<TUserAddress> list, @Param("selective") TUserAddress.Column... selective);
}