package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.category.CategoryService;
import com.xiaozipu.service.pojo.dto.category.AddCategoryReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 添加分类
     *
     * @param addCategoryReqDTO
     * @return
     */
    @PostMapping("/category/add")
    public ResultInfo addCategory(AddCategoryReqDTO addCategoryReqDTO) {
        ResultInfo resultInfo = new ResultInfo();
        categoryService.addCategory(addCategoryReqDTO);
        resultInfo.setData("");
        return resultInfo;
    }
}
