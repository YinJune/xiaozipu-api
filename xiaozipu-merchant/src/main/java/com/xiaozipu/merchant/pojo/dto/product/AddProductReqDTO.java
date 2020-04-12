package com.xiaozipu.merchant.pojo.dto.product;

import com.xiaozipu.merchant.pojo.dto.CommonKV;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 20:16
 * @description:
 */
@Data
public class AddProductReqDTO {
    /**
     * 商品名称
     */
    @NotEmpty(message = "商品名称不能为空")
    private String name;
    /**
     * 商品名称
     */
    @NotEmpty(message = "商品简介不能为空")
    private String summary;
    /**
     * 商品价格
     */
    @NotNull(message = "商品价格不能为空")
    private BigDecimal price;
    /**
     * 划线价
     */
    private BigDecimal lineationPrice;
    /**
     * 分类id
     */
    @NotNull(message = "分类Id不能为空")
    private Integer categoryId;

    /**
     * 商品图片 k 是否主图 v url
     */
    @NotEmpty(message = "商品图片不能为空")
    private List<CommonKV> imageList;

    /**
     * 商品描述
     */
    @NotEmpty(message = "商品描述不能为空")
    private String description;
}
