package com.xiaozipu.merchant.pojo.dto.vo.order;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/4/5 18:04
 * @description:
 */
@Data
public class OrderListVO {
    private Integer orderId;
    private String orderCode;
    private String orderStatus;
}
