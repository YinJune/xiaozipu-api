package com.xiaozipu.merchant.service.spec;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.dao.entity.TSpecName;
import com.xiaozipu.dao.entity.TSpecValue;
import com.xiaozipu.dao.mapper.TSpecNameMapper;
import com.xiaozipu.dao.mapper.TSpecValueMapper;
import com.xiaozipu.merchant.pojo.dto.spec.AddSpecNameReqDTO;
import com.xiaozipu.merchant.pojo.dto.spec.AddSpecValueReqDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 13:50
 * @description:
 */
@Service
public class SpecServiceImpl implements SpecService {
    @Resource
    private TSpecNameMapper specNameMapper;
    @Resource
    private TSpecValueMapper specValueMapper;

    /**
     * 添加规格名
     *
     * @param addSpecNameReqDto
     * @return
     */
    @Override
    public Integer addSpecName(AddSpecNameReqDTO addSpecNameReqDto) {
        TSpecName specName = new TSpecName();
        specName.setProductId(addSpecNameReqDto.getProductId());
        specName.setName(addSpecNameReqDto.getName());
        specName.setDeleted(StatusEnum.INVALID.getKey());
        specNameMapper.insertSelective(specName);
        return specName.getId();
    }

    /**
     * 添加规格值
     *
     * @param addSpecValueReqDto
     * @return
     */
    @Override
    public Integer addSpecValue(AddSpecValueReqDTO addSpecValueReqDto) {
        TSpecValue specValue = new TSpecValue();
        specValue.setValue(addSpecValueReqDto.getValue());
        specValue.setNameId(addSpecValueReqDto.getNameId());
        specValue.setDeleted(StatusEnum.INVALID.getKey());
        specValueMapper.insertSelective(specValue);
        return specValue.getId();
    }

    /**
     * 删除规格
     *
     * @param specId
     */
    @Override
    public void deleteSpecName(Integer specId) {
        TSpecName specName = getSpecNameById(specId);
        //查询订单是否有商品 有的话软删除
//        if (specName != null) {
//            specName.setDeleted(StatusEnum.VALID.getKey());
//            specNameMapper.updateByPrimaryKeySelective(specName);
//        } else {
//            specNameMapper.deleteByPrimaryKey(specId);
//        }
    }

    /**
     * 删除规格值
     *
     * @param valueId
     */
    @Override
    public void deleteSpecValue(Integer valueId) {

    }

    /**
     * 根据id查询规格名称
     *
     * @param specId
     * @return
     */
    @Override
    public TSpecName getSpecNameById(Integer specId) {
        return specNameMapper.selectByPrimaryKey(specId);
    }

    /**
     * 根据id查询规格值
     *
     * @param valueId
     * @return
     */
    @Override
    public TSpecValue getSpecValueById(Integer valueId) {
        return specValueMapper.selectByPrimaryKey(valueId);
    }
}
