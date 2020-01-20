package com.xiaozipu.service.pojo.dto.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:08
 * @description:
 */
@Data
public class AddSpecsReqDto {
    /**
     * 规格名称
     */
    private String specName;
    /**
     * 该规格单价
     */
    private BigDecimal specPrice;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 库存
     */
    private Integer stock;
}
