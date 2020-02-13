package com.xiaozipu.merchant.service.category;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.dao.entity.generator.TCategory;
import com.xiaozipu.dao.entity.generator.TCategoryExample;
import com.xiaozipu.dao.mapper.generator.TCategoryMapper;
import com.xiaozipu.merchant.pojo.dto.category.AddCategoryReqDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:58
 * @description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private TCategoryMapper categoryMapper;

    /**
     * 添加分类
     *
     * @param addCategoryReqDTO
     */
    @Override
    public void addCategory(AddCategoryReqDTO addCategoryReqDTO) {
        TCategory tCategory = new TCategory();
        BeanUtils.copyProperties(addCategoryReqDTO, tCategory);
        tCategory.setStatus(StatusEnum.VALID.getKey());
        tCategory.setDeleted(StatusEnum.INVALID.getKey());
        categoryMapper.insertSelective(tCategory);
    }

    /**
     * 查询分类
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<TCategory> getCategoryList(Integer categoryId) {
        List<TCategory> categoryList = null;
        TCategoryExample categoryExample = new TCategoryExample();
        if (categoryId == null) {
            categoryExample.createCriteria().andStatusEqualTo(StatusEnum.VALID.getKey()).andDeletedEqualTo(StatusEnum.INVALID.getKey());
        } else {
            categoryExample.createCriteria().andStatusEqualTo(StatusEnum.VALID.getKey()).andDeletedEqualTo(StatusEnum.INVALID.getKey()).andParentIdEqualTo(categoryId);
        }
        categoryList = categoryMapper.selectByExample(categoryExample);
        return categoryList;
    }
}
