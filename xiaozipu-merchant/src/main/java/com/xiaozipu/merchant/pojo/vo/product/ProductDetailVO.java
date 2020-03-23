package com.xiaozipu.merchant.pojo.vo.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/3/23 12:12
 * @description:
 */
@Data
public class ProductDetailVO {
    private Integer productId;
    private String name;
    private String code;
    private String summary;
    private List<ProductImageVO> productImageVOS;
    private Integer categoryId;
    private BigDecimal price;
    private BigDecimal lineaionPrice;
    private String status;
    private String reviewStatus;
    private String description;
    private Integer stock;
    //规格信息
    private List<ProductSpecVO> productSpecVOS;
}
