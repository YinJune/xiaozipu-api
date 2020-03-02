package com.xiaozipu.merchant.pojo.dto.product;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:08
 * @description:
 */
@Data
public class AddSpecsReqDTO {

    /**
     * 规格组合
     */
    @NotEmpty(message = "规格组合不能为空")
    private String specs;
    /**
     * 规格组合
     */
    @NotEmpty(message = "规格组合不能为空")
    private String name;
    /**
     * 该组合规格售价
     */
    @NotNull(message = "规格售价不能为空")
    private BigDecimal price;
    /**
     * 该规格成本价
     */
    @NotNull(message = "规格成本价不能为空")
    private BigDecimal costPrice;
    /**
     * 库存
     */
    @NotNull(message = "库存不能为空")
    private Integer stock;
    /**
     * 规格图片
     */
    private String specImageUrl;
}
