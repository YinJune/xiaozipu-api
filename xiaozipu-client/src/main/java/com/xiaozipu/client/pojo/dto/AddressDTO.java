package com.xiaozipu.client.pojo.dto;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 16:22
 * @description:
 */
@Data
public class AddressDTO {
    /**
     * 更新时传，添加是不传
     */
    private Integer id;
    /**
     * 收货人姓名
     */
    private String recipientName;
    /**
     * 收货人手机号
     */
    private String recipientPhone;
    /**
     * 省份 code
     */
    private String province;
    /**
     * 城市 code
     */
    private String city;
    /**
     * 地区 code
     */
    private String district;
    /**
     * 详细地址
     */
    private String addressDetail;
    /**
     * 是否默认地址
     */
    private String isDefault;
}
