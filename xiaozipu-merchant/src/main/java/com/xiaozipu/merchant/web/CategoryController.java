package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:57
 * @description:
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public ResultInfo addCategory(AddCategoryReqDto addCategoryReqDto){
        ResultInfo resultInfo=new ResultInfo();
        categoryService.addCategory();
        resultInfo.setData("");
        return resultInfo;
    }
}
