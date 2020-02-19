package com.xiaozipu.client.web;

import com.xiaozipu.client.pojo.vo.ProductSummaryVO;
import com.xiaozipu.client.service.product.ProductService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
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
 * @date: 2020/1/12 11:48
 * @description:
 */
//@Api(tags = "商品模块")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    //    @ApiOperation(value = "排行榜")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "sortType", value = "排序类型 1：时间，2：销量", required = true, paramType = "form")
//    })

    /**
     * 商品列表
     *
     * @param sortType    排序字段 时间 销量 价格
     * @param currentPage 当前页
     * @param orderType   排序类型 正序 倒叙
     * @return
     */
    @GetMapping("/product/list")
    public ResultInfo getRankingList(@RequestParam(value = "sortType", defaultValue = "1") String sortType,
                                     @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                     @RequestParam(value = "orderType", defaultValue = "1") String orderType) {
        ResultInfo resultInfo = new ResultInfo();
        List<ProductSummaryDO> productSummaryDOS = productService.getProductList(currentPage, sortType, orderType);
        List<ProductSummaryVO> productSummaryResDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productSummaryDOS)) {
            for (ProductSummaryDO productSummaryDO : productSummaryDOS) {
                ProductSummaryVO productSummaryVO = new ProductSummaryVO();
                BeanUtils.copyProperties(productSummaryDO, productSummaryVO);
                productSummaryResDTOS.add(productSummaryVO);
            }
        }
        resultInfo.setData(productSummaryResDTOS);
        return resultInfo;
    }
}
