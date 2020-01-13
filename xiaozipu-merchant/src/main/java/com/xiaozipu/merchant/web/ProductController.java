package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.domain.dto.AddProductReqDto;
import com.xiaozipu.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 11:48
 * @description:
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/add")
    public ResultInfo getRankingList(AddProductReqDto addProductReqDto) {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }
}
