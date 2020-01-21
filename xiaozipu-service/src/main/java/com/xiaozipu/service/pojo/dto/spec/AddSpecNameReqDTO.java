package com.xiaozipu.service.pojo.dto.spec;

import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 14:13
 * @description:
 */
@Data
public class AddSpecNameReqDTO {
    /**
     * 商品规格名称
     */
    private String name;
    /**
     * 商品id
     */
    private Integer productId;
}
