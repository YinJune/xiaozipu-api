package com.xiaozipu.client.pojo.dto.mp;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/27 20:07
 * @description: 详见微信支付文档
 */
@Data
public class UnifiedOrderResDTO {
    //通信标识
    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    //交易标识
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String trade_type;
    private String prepay_id;
    private String code_url;
}
