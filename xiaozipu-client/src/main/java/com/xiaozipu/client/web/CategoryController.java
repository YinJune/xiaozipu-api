package com.xiaozipu.client.web;

import com.xiaozipu.client.common.annotation.TraceLog;
import com.xiaozipu.client.pojo.vo.CategoryVO;
import com.xiaozipu.client.service.category.CategoryService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.dao.entity.TCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @param categoryId 不传 查全部一级分类
     * @return
     */
    @TraceLog
    @GetMapping("/anon/category/list")
    public ResultInfo getCategoryList(@RequestParam(value = "categoryId", required = false) Integer categoryId) {
        ResultInfo resultInfo = new ResultInfo();
        List<TCategory> categoryList = categoryService.getCategoryList(categoryId);
        if (!CollectionUtils.isEmpty(categoryList)) {
            List<CategoryVO> categoryVOList = new ArrayList<>();
            for (TCategory category : categoryList) {
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(category, categoryVO);
                categoryVOList.add(categoryVO);
            }
            resultInfo.setData(categoryVOList);
        }
        return resultInfo;
    }
}
