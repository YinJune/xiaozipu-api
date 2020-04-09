package com.xiaozipu.client.web;

import com.xiaozipu.client.common.annotation.TraceLog;
import com.xiaozipu.client.pojo.vo.product.ProductSummaryVO;
import com.xiaozipu.client.service.product.RecommendProductService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.client.dao.entity.ProductSummaryDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date: 2020/1/12 15:11
 * @description:
 */
//@Api(tags = "推荐商品接口")
@RestController
public class RecommendProductController {

    private static final Logger logger = LoggerFactory.getLogger(RecommendProductController.class);

    @Autowired
    private RecommendProductService recommendProductService;


    //    @ApiOperation(value = "推荐商品列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "currentPage", value = "当前页", required = true, paramType = "form")
//    })
    @TraceLog(desc = "推荐商品列表")
    @GetMapping("/product/recommend/list")
    public ResultInfo listRecommendProduct(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
        ResultInfo resultInfo = new ResultInfo();
        logger.info("推荐商品列表:{}", currentPage);
        List<ProductSummaryDO> productSummaryDOS = recommendProductService.listRecommendProduct(currentPage);
        List<ProductSummaryVO> productSummaryVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productSummaryDOS)) {
            for (ProductSummaryDO productSummaryDO : productSummaryDOS) {
                ProductSummaryVO productSummaryVO = new ProductSummaryVO();
                BeanUtils.copyProperties(productSummaryDO, productSummaryVO);
                productSummaryVOS.add(productSummaryVO);
            }
        }
        resultInfo.setData(productSummaryVOS);
        return resultInfo;
    }
}
