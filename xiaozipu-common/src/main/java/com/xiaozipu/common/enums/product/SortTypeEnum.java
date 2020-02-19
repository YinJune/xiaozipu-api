package com.xiaozipu.common.enums.product;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 13:51
 * @description:
 */
public enum SortTypeEnum {
    TIME("1", "create_time", "时间"),
    SALES_VOLUME("2", "volume", "销量"),
    PRICE("3", "price", "销量");
    private String type;
    private String column;
    private String desc;

    SortTypeEnum(String type, String column, String desc) {
        this.type = type;
        this.column = column;
        this.desc = desc;
    }

    public static SortTypeEnum getEnumByType(String type) {
        for (SortTypeEnum sortTypeEnum : SortTypeEnum.values()) {
            if (sortTypeEnum.getType().equals(type)) {
                return sortTypeEnum;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getColumn() {
        return column;
    }
}
