package com.xiaozipu.client.service.category;

import com.xiaozipu.dao.entity.generator.TCategory;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:57
 * @description:
 */
public interface CategoryService {


    /**
     * 查询分类
     *
     * @param categoryId
     * @return
     */
    List<TCategory> getCategoryList(Integer categoryId);
}
