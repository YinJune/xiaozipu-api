package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.merchant.pojo.dto.product.recommend.AddRecommendProductReqDTO;
import com.xiaozipu.merchant.service.product.RecommendProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultInfo addRecommendProduct(@RequestBody AddRecommendProductReqDTO addRecommendProductReqDTO) {
        ResultInfo resultInfo = new ResultInfo();
        recommendProductService.insertRecommendProduct(addRecommendProductReqDTO);
        return resultInfo;
    }
}
