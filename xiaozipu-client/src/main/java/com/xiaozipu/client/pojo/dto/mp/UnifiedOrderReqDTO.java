package com.xiaozipu.client.pojo.dto.mp;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/27 20:14
 * @description: 详见微信支付文档
 */
@Data
public class UnifiedOrderReqDTO {
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String body;
    private String detail;
    private String out_trade_no;
    private String fee_type;
    private String total_fee;
    private String spbill_create_ip;
    private String notify_url;
    private String trade_type;
    private String openid;
}
