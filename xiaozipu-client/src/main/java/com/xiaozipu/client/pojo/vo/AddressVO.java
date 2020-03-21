package com.xiaozipu.client.pojo.vo;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 16:04
 * @description:
 */
@Data
public class AddressVO {
    private Integer id;
    private String recipientName;
    private String recipientPhone;
    private String addressDetail;
    /**
     * 是否是默认地址
     */
    private String isDefault;
}
