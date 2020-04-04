package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.config.MyWXPayConfig;
import com.xiaozipu.client.pojo.dto.mp.PaymentNotifyResDTO;
import com.xiaozipu.client.service.payment.PaymentService;
import com.xiaozipu.client.service.wx.pay.WXPay;
import com.xiaozipu.client.service.wx.pay.WXPayUtil;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/3/25 19:38
 * @description:
 */
@RestController
public class PayCallbackController {

    private static final Logger logger = LoggerFactory.getLogger(PayCallbackController.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private MyWXPayConfig myWXPayConfig;

    /**
     * 微信支付回调
     *
     * @param request
     * @return
     */
    @GetMapping("/notify/wxpay/order")
    public String payCallback(HttpServletRequest request) {
        String result = "FAIL";
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        StringBuffer xmlData = new StringBuffer();
        try {
            inputStream = request.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                xmlData.append(line + "\n");
            }
        } catch (IOException e) {
            logger.error("读取微信支付回调数据异常:{}", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("关闭输入流异常:{}", e);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error("关闭缓冲输入流异常:{}", e);
                }
            }
        }
        String notifyData = "...."; // 支付结果通知的xml格式数据

        WXPay wxpay = null;
        try {
            wxpay = new WXPay(myWXPayConfig);
        } catch (Exception e) {
            logger.error("支付回调异常:{}", e);
        }

        Map<String, String> notifyMap = null;  // 转换成map
        try {
            notifyMap = WXPayUtil.xmlToMap(notifyData);
        } catch (Exception e) {
            logger.error("xml转map错误:{}", e);
        }

        try {
            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
                // 签名正确
                // 进行处理。
                // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
                PaymentNotifyResDTO paymentNotifyResDTO = JSONObject.parseObject(JSONObject.toJSONString(notifyMap)).toJavaObject(PaymentNotifyResDTO.class);
                paymentService.payCallback(paymentNotifyResDTO);
                result = "SUCCESS";
            } else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
                logger.error("签名错误:{}");
            }
        } catch (Exception e) {
            logger.error("支付回调异常:{}", e);
        }

        return result;
    }
}
