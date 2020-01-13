package com.xiaozipu.client.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 15:11
 * @description:
 */
@Api(tags = "推荐商品接口")
@RestController
public class RecommendProductController {
//    @Autowired
//    private RecommendProductService recommendProductService;
//
//
//    @ApiOperation(value = "推荐商品列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "currentPage", value = "当前页", required = true, paramType = "form")
//    })
//    @GetMapping("/product/recommend/list")
//    public ResultInfo listRecommendProduct(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
//        ResultInfo resultInfo = new ResultInfo();
//        List<ProductSummaryBO> productSummaryBOList = recommendProductService.listRecommendProduct(currentPage);
//        List<ProductSummaryResDTO> productSummaryResDTOList=new ArrayList<>();
//        BeanUtils.copyProperties(productSummaryBOList,productSummaryResDTOList);
//        resultInfo.setData(productSummaryResDTOList);
//        return resultInfo;
//    }
}
