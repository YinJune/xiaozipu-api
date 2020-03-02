package com.xiaozipu.client.pojo.vo.order;

import com.xiaozipu.client.pojo.vo.AddressVO;
import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/3/2 21:06
 * @description:
 */
@Data
public class OrderDetailVO extends OrderListVO {
    /**
     * 地址信息
     */
    private AddressVO addressVO;
}
