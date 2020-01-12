package com.xiaozipu.client.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.bo.ProductSummaryBO;
import com.xiaozipu.service.product.RecommendProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/product/recommend/list")
    public ResultInfo listRecommendProduct(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage){
        ResultInfo resultInfo=new ResultInfo();
        List<ProductSummaryBO> productSummaryBOList= recommendProductService.listRecommendProduct(currentPage);
        resultInfo.setData(productSummaryBOList);
       return resultInfo;
    }
}
