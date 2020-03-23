package com.xiaozipu.merchant.pojo.vo.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/3/23 13:01
 * @description:
 */
@Data
public class ProductSpecVO {
    private Integer specId;
    private Integer specNameId;
    private String specName;
    private Integer specValueId;
    private String specValue;
    private BigDecimal price;
    private BigDecimal costPrice;
    private String specImageUrl;
    private Integer stock;
    private String status;
}
