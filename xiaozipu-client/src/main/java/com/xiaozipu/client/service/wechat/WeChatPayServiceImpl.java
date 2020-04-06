package com.xiaozipu.client.service.wechat;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.config.MyWXPayConfig;
import com.xiaozipu.client.config.WxConfig;
import com.xiaozipu.client.enums.UserThirdTypeEnum;
import com.xiaozipu.client.pojo.dto.mp.UnifiedOrderReqDTO;
import com.xiaozipu.client.pojo.dto.mp.UnifiedOrderResDTO;
import com.xiaozipu.client.pojo.vo.UnifiedOrderResVO;
import com.xiaozipu.client.service.user.UserService;
import com.xiaozipu.client.service.wx.pay.WXPay;
import com.xiaozipu.client.service.wx.pay.WXPayConfig;
import com.xiaozipu.client.service.wx.pay.WXPayConstants;
import com.xiaozipu.client.service.wx.pay.WXPayUtil;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.dao.entity.TOrder;
import com.xiaozipu.dao.entity.TUserThird;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 23:10
 * @description:
 */
@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    private static final Logger logger = LoggerFactory.getLogger(WeChatPayServiceImpl.class);

    private static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private static final String SUCCESS = "SUCCESS";

    private String notifyUrl = "http://20o609b535.imwork.net/client/notify/wxpay/order";
    @Autowired
    private UserService userService;

    @Autowired
    private MyWXPayConfig myWXPayConfig;

    @Autowired
    private WxConfig wxConfig;

    /**
     * 微信支付统一下单
     *
     * @param order
     */
    @Override
    public UnifiedOrderResVO unifiedOrder(TOrder order) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        TUserThird userThird = userService.getUserThirdByType(order.getUserId(), UserThirdTypeEnum.WECHAT.getKey());
        WXPay wxpay = null;
        try {
//            wxpay = new WXPay(myWXPayConfig,false,true);
            wxpay = new WXPay(myWXPayConfig);
        } catch (Exception e) {
            logger.error("创建微信支付请求对象异常:{}", e);
        }
        Map<String, String> data = new HashMap<String, String>();
        // appid mch_id nonce_str sign sign_type fillRequestData中填充
        data.put("device_info", "MP");
        data.put("body", "小资铺-化妆品");
//        data.put("detail", "小资铺商品嘿嘿");
        data.put("out_trade_no", order.getOrderCode());
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", getIpAddr(request));
        data.put("notify_url", notifyUrl);
        data.put("trade_type", "JSAPI");  //
        data.put("openid", userThird.getOpenId());

        UnifiedOrderResDTO unifiedOrderResDTO;
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            unifiedOrderResDTO = JSONObject.parseObject(JSONObject.toJSONString(resp)).toJavaObject(UnifiedOrderResDTO.class);
            logger.info("微信支付统一下单返回:{}", resp);
        } catch (Exception e) {
            logger.error("微信支付统一下单异常:{}", e);
            throw new BusinessRuntimeException("", "下单失败");
        }
        if (!SUCCESS.equals(unifiedOrderResDTO.getReturn_code())) {
            logger.info("微信支付统一下单失败:{}", unifiedOrderResDTO);
            throw new BusinessRuntimeException("", "微信支付统一下单通信失败");
        }
        if (!SUCCESS.equals(unifiedOrderResDTO.getResult_code())) {
            logger.info("微信支付统一下单失败:{}", unifiedOrderResDTO);
            throw new BusinessRuntimeException("", "微信支付统一下单通信失败");
        }
        //通信标识和交易标识都为成功 则为交易成功
        unifiedOrderResDTO.setNonce_str(WXPayUtil.generateNonceStr());

        //------------
        //返回给APP端的参数，APP端再调起支付接口
        Map<String, String> repData = new HashMap<>();
        UnifiedOrderResVO unifiedOrderResVO = new UnifiedOrderResVO();
        //注意参数要区分大小写
        repData.put("appId", wxConfig.getAppId());
        String packag = "prepay_id=" + unifiedOrderResDTO.getPrepay_id();
        repData.put("package", packag);
        //要添加签名方式
        repData.put("signType", "HMAC-SHA256");
        String nonStr = WXPayUtil.generateNonceStr();
        repData.put("nonceStr", nonStr);
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        repData.put("timeStamp", timeStamp);
        //签名
        String key = "03447810be8fc1d58d64eb9ea3a73cc0";
        String sign = WXPayUtil.generateSignature(repData, key);
        unifiedOrderResVO.setPackageStr(packag);
        unifiedOrderResVO.setTimeStamp(timeStamp);
        unifiedOrderResVO.setNonce_str(nonStr);
        unifiedOrderResVO.setSignType("HMAC-SHA256");
        unifiedOrderResVO.setPaySign(sign);
        logger.info("返回前端：{}", JSONObject.toJSONString(unifiedOrderResVO));
        return unifiedOrderResVO;
    }

    /**
     * 获取客户端的IP地址
     *
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    logger.error("获取ip异常:", e);
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
