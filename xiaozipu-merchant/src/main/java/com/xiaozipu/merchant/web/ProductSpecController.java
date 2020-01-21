package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.pojo.dto.product.AddProductSpecReqDTO;
import com.xiaozipu.service.product.ProductSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     *
     * @param addProductSpecReqDTOS
     * @return
     */
    @PostMapping("/product/spec/add")
    public ResultInfo addProductSpec(@RequestBody List<AddProductSpecReqDTO> addProductSpecReqDTOS) {
        ResultInfo resultInfo = new ResultInfo();
        productSpecService.addProductSpec(addProductSpecReqDTOS);
        return resultInfo;
    }
}
