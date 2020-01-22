package com.xiaozipu.service.category;

import com.xiaozipu.dao.entity.generator.TCategory;
import com.xiaozipu.service.pojo.dto.category.AddCategoryReqDTO;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:57
 * @description:
 */
public interface CategoryService {
    /**
     * 添加分类
     *
     * @param addCategoryReqDTO
     */
    void addCategory(AddCategoryReqDTO addCategoryReqDTO);

    /**
     * 查询分类
     *
     * @param categoryId
     * @return
     */
    List<TCategory> getCategoryList(Integer categoryId);
}
