package com.xiaozipu.client.pojo.vo;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/22 15:43
 * @description:
 */
@Data
public class CategoryVO {
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 图片url
     */
    private String imageUrl;
    /**
     * 状态
     */
    private String status;
    /**
     * 等级
     */
    private String level;
    /**
     * 父分类id
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sortNum;

}
