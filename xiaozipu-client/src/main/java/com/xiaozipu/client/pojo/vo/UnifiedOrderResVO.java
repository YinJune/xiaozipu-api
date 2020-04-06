package com.xiaozipu.client.pojo.vo;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/3/30 18:55
 * @description:
 */
@Data
public class UnifiedOrderResVO {
    private String nonce_str;
    private String packageStr;
    private String timeStamp;
    private String signType;
    private String paySign;
    private Integer orderId;
}
