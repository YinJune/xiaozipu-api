package com.xiaozipu.common.enums;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 13:51
 * @description:
 */
public enum RankingListTypeEnum {
    TIME("1", "时间"),
    SALES_VOLUME("2", "销量");
    private String key;
    private String value;

    RankingListTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
