package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.product.RecommendProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:11
 * @description:
 */
@RestController
public class RecommendProductController {
    @Autowired
    private RecommendProductService recommendProductService;

    @PostMapping("/product/recommend/add")
    public ResultInfo addRecommendProduct(@RequestParam("productIds") List<Integer> productIds){
        ResultInfo resultInfo=new ResultInfo();
        recommendProductService.insertRecommendProduct(productIds);
       return resultInfo;
    }
}
