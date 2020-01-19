package com.xiaozipu.service.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author: YinJunJie
 * @date: 2020/1/8 21:36
 * @description:
 */
@Data
public class AddBannerReqDto {
    @NotEmpty(message = "banner name不能为空")
    private String name;
    @NotEmpty(message = "banner position不能为空")
    private String position;
    @NotEmpty(message = "banner bannerUrl不能为空")
    private String bannerUrl;
    @NotEmpty(message = "banner redirectUrl不能为空")
    private String redirectUrl;
    @NotEmpty(message = "banner redirectType不能为空")
    private String redirectType;
}
