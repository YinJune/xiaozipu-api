package com.xiaozipu.common.enums.banner;

/**
 * @author: YinJunJie
 * @date: 2020/2/14 13:26
 * @description:
 */
public enum BannerPositionEnum {
    INDEX_TOP("INDEX_TOP", "首页顶部"),
    RANK("RANK", "排行榜"),
    HOT("HOT", "人气推荐");
    private String position;
    private String description;

    BannerPositionEnum(String position, String description) {
        this.position = position;
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }
}
