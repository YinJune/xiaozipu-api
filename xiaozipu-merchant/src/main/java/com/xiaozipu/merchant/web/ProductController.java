package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.merchant.pojo.dto.product.AddProductReqDTO;
import com.xiaozipu.merchant.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 添加商品
     *
     * @param addProductReqDto
     * @return
     */
    @PostMapping("/product/add")
    public ResultInfo addProduct(@RequestBody @Validated AddProductReqDTO addProductReqDto) {
        ResultInfo resultInfo = new ResultInfo();
        Integer productId = productService.addProduct(addProductReqDto);
        resultInfo.setData(productId);
        return resultInfo;
    }

    /**
     * 添加商品
     *
     * @param
     * @return
     */
    @PostMapping("/product/update/status/{productId}/{status}")
    public ResultInfo updateProductStatus(@PathVariable("productId") Integer productId,@PathVariable("status")String status) {
        ResultInfo resultInfo = new ResultInfo();
        productService.updateProductStatus(productId,status);
        return resultInfo;
    }
}