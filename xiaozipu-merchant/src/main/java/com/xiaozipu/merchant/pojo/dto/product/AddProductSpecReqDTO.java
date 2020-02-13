package com.xiaozipu.merchant.pojo.dto.product;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 15:20
 * @description: 添加商品时候的 货品 sku
 */
@Data
public class AddProductSpecReqDTO {

    /**
     * 商品id
     */
    @NotNull(message = "商品id不能为空")
    private Integer productId;

    /**
     * 商品规格
     */
    @NotEmpty(message = "商品规格不能为空")
    @Valid
    private List<AddSpecsReqDTO> specsReqDTOList;
}
