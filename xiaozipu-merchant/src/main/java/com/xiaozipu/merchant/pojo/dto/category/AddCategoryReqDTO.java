package com.xiaozipu.merchant.pojo.dto.category;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "分类名称不能为空")
    private String name;
    /**
     * 分类图片
     */
    @NotEmpty(message = "分类图片不能为空")
    private String imageUrl;
    /**
     * 父类目 一级为空
     */
    private Integer parentId;
    /**
     * 状态
     */
    private String level;
    /**
     * 越大越靠前
     */
    private Integer sortNum;
}
