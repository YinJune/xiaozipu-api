package com.xiaozipu.client.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 12:47
 * @description:
 */
@Data
public class DeleteCartDTO {
    /**
     * 购物车id
     */
    private List<Integer> ids;
}
