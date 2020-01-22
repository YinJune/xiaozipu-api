package com.xiaozipu.service.pojo.dto.category;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:59
 * @description:
 */
@Data
public class AddCategoryReqDTO {
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类图片
     */
    private String imageUrl;
    /**
     * 父类目 一级为空
     */
    private Integer parentId;
    /**
     * 状态
     */
    private String status;
}
