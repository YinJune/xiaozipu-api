package com.xiaozipu.client.service.wechat;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.config.MyWXPayConfig;
import com.xiaozipu.client.pojo.dto.mp.UnifiedOrderReqDTO;
import com.xiaozipu.client.pojo.dto.mp.UnifiedOrderResDTO;
import com.xiaozipu.client.service.wx.pay.WXPay;
import com.xiaozipu.client.service.wx.pay.WXPayConfig;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.dao.entity.TOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 23:10
 * @description:
 */
@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    private static final Logger logger= LoggerFactory.getLogger(WeChatPayServiceImpl.class);

    private static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private static final String SUCCESS = "SUCCESS";

    /**
     * 微信支付统一下单
     *
     * @param order
     */
    @Override
    public String unifiedOrder(TOrder order) {

        WXPayConfig config = new MyWXPayConfig() ;
        WXPay wxpay = null;
        try {
            wxpay = new WXPay(config);
        } catch (Exception e) {
           logger.error("创建微信支付请求对象异常:{}",e);
        }
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "小资铺商品");
        data.put("detail", "小资铺商品嘿嘿");
        data.put("out_trade_no", order.getOrderCode());
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "JSAPI");  //
        data.put("openid", "12");
        data.put("product_id", "12");

        UnifiedOrderResDTO unifiedOrderResDTO;
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
             unifiedOrderResDTO=JSONObject.parseObject(JSONObject.toJSONString(resp)).toJavaObject(UnifiedOrderResDTO.class);
            logger.info("微信支付统一下单返回:{}",resp);
        } catch (Exception e) {
            logger.error("微信支付统一下单异常:{}",e);
            throw new BusinessRuntimeException("","下单失败");
        }
        if (!SUCCESS.equals(unifiedOrderResDTO.getReturn_code())){
            logger.info("微信支付统一下单失败:{}",unifiedOrderResDTO);
            throw new BusinessRuntimeException("","微信支付统一下单通信失败");
        }
        if (!SUCCESS.equals(unifiedOrderResDTO.getResult_code())){
            logger.info("微信支付统一下单失败:{}",unifiedOrderResDTO);
            throw new BusinessRuntimeException("","微信支付统一下单通信失败");
        }
        //通信标识和交易标识都为成功 则为交易成功

        return unifiedOrderResDTO.getPrepay_id();
    }
}
