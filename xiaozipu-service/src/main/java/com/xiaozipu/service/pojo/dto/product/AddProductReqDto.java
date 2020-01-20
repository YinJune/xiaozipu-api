package com.xiaozipu.service.pojo.dto.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 20:16
 * @description:
 */
@Data
public class AddProductReqDto {
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 划线价
     */
    private BigDecimal lineationPrice;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     * 规格
     */
    private List<AddSpecsReqDto> addSpecsReqDtoList;
}
