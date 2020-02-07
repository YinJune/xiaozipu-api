package com.xiaozipu.client.pojo.vo;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 13:08
 * @description:
 */
@Data
public class BannerVO {
    private Integer id;
    private String name;
    private String position;
    private String bannerUrl;
    private String redirectUrl;
    private String redirectType;
}
