package com.xiaozipu.client.pojo.dto.order;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 16:39
 * @description:
 */
@Data
public class PlaceOrderDTO extends CalculateAmountDTO {
    /**
     * 地址id
     */
    @NotNull(message = "地址不能为空")
    private Integer addressId;
    /**
     * 支付方式
     */
    @NotNull(message = "支付方式不能为空")
    private String payType;
}
