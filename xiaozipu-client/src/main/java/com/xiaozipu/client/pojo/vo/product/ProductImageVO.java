package com.xiaozipu.client.pojo.vo.product;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/20 18:02
 * @description:
 */
@Data
public class ProductImageVO {
    /**
     * 1:主图 2:普通图
     */
    private String type;
    /**
     * 图片url
     */
    private String imageUrl;
}
