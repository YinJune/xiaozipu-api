package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.merchant.common.annotation.TraceLog;
import com.xiaozipu.merchant.pojo.dto.product.AddProductSpecReqDTO;
import com.xiaozipu.merchant.service.product.ProductSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:18
 * @description:
 */
@RestController
public class ProductSpecController {
    @Autowired
    private ProductSpecService productSpecService;

    /**
     * 添加商品规格
     * 先添加商品规格 属性名 属性值，再关联商品
     *
     * @param addProductSpecReqDTO
     * @return
     */
    @TraceLog(desc = "添加商品规格")
    @PostMapping("/product/spec/add")
    public ResultInfo addProductSpec(@RequestBody @Validated AddProductSpecReqDTO addProductSpecReqDTO) {
        ResultInfo resultInfo = new ResultInfo();
        productSpecService.addProductSpec(addProductSpecReqDTO);
        return resultInfo;
    }
}
