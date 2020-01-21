package com.xiaozipu.service.enums.product;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 16:03
 * @description:
 */
public enum ProductImageTypeEnum {
    MAIN("1","主图"),
    BANNER("2","展示轮播图");
    private String key;
    private String value;

    ProductImageTypeEnum(String key, String value) {
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
