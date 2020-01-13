package com.xiaozipu.client.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 11:48
 * @description:
 */
@Api(tags = "商品模块")
@RestController
public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    @ApiOperation(value = "排行榜")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "type", value = "排序类型 1：时间，2：销量", required = true, paramType = "form")
//    })
//    @GetMapping("/product/ranking/list")
//    public ResultInfo getRankingList(@RequestParam(value = "type", defaultValue = "2") String type,
//                                     @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
//        ResultInfo resultInfo = new ResultInfo();
//        List<ProductSummaryBO> productSummaryBOS = productService.getRankingList(currentPage, type);
//        List<ProductSummaryResDTO> productSummaryResDTOS = new ArrayList<>();
//        BeanUtils.copyProperties(productSummaryBOS, productSummaryResDTOS);
//        resultInfo.setData(productSummaryResDTOS);
//        return resultInfo;
//    }
}
