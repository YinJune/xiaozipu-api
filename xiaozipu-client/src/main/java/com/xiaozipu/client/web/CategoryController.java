package com.xiaozipu.client.web;

import com.xiaozipu.client.pojo.vo.CategoryVO;
import com.xiaozipu.client.service.category.CategoryService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.dao.entity.generator.TCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:57
 * @description:
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 分类列表
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/category/list/{categoryId}")
    public ResultInfo getCategoryList(@PathVariable("categoryId") Integer categoryId) {
        ResultInfo resultInfo = new ResultInfo();
        List<TCategory> categoryList = categoryService.getCategoryList(categoryId);
        if (!CollectionUtils.isEmpty(categoryList)) {
            List<CategoryVO> categoryVOList = new ArrayList<>();
            BeanUtils.copyProperties(categoryList, categoryVOList);
            resultInfo.setData(categoryVOList);
        }
        return resultInfo;
    }
}
