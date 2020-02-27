package com.xiaozipu.client.pojo.vo.product;

import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/20 18:20
 * @description:
 */
@Data
public class SpecNameValueVO {
    /**
     * 规格名
     */
    private String name;
    /**
     * 规格值
     */
    private List<SpecValueVO> values;

}
