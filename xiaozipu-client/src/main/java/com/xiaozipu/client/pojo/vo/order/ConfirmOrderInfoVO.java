package com.xiaozipu.client.pojo.vo.order;

import com.xiaozipu.client.pojo.vo.AddressVO;
import com.xiaozipu.client.pojo.vo.product.CartProductVO;
import com.xiaozipu.client.pojo.vo.product.ProductSummaryVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/3/21 17:35
 * @description:
 */
@Data
public class ConfirmOrderInfoVO {
    private AddressVO addressVO;
    private List<CartProductVO> cartProductVOS;
    private BigDecimal orderAmount;
    private BigDecimal payAmount;
}
