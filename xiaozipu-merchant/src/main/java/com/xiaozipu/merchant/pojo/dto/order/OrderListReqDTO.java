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
    private String orderCode;
    private String productCode;
    private String userId;
    private String orderStatus;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDateTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDateTime;

}
