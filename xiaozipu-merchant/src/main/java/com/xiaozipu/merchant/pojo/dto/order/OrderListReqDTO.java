package com.xiaozipu.merchant.pojo.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: YinJunJie
 * @date: 2020/4/5 17:55
 * @description:
 */
@Data
public class OrderListReqDTO {
    @NotNull(message = "当前页不能为空")
    private Integer currentPage;
    //订单编号
    private String orderCode;
    //商品编号
    private String productCode;
    //用户id
    private String userId;
    //订单状态
    private String orderStatus;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    //订单创建开始时间
    private Date startDateTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    //订单创建结束时间
    private Date endDateTime;
}
