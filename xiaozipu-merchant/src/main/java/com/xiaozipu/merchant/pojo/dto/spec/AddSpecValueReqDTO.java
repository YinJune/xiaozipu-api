package com.xiaozipu.merchant.pojo.dto.spec;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 14:13
 * @description:
 */
@Data
public class AddSpecValueReqDTO {
    /**
     * 商品规格值
     */
    private String value;
    /**
     * 规格id
     */
    private Integer specId;
}
