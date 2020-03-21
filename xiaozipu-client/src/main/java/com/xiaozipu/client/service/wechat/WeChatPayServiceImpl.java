package com.xiaozipu.client.service.wechat;

import com.xiaozipu.client.config.WxConfig;
import com.xiaozipu.dao.entity.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 23:10
 * @description:
 */
@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    private static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private static final String SUCCESS = "SUCCESS";
    @Autowired
    private WxConfig wxConfig;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 微信支付统一下单
     *
     * @param order
     */
    @Override
    public void unifiedOrder(TOrder order) {
//        UnifiedOrderReqDTO reqDTO = new UnifiedOrderReqDTO();
//        reqDTO.setAppid(wxConfig.getAppId());
//        reqDTO.setMch_id(wxConfig.getMchId());
//        reqDTO.setNonce_str("");
//        reqDTO.setSign("");
//        reqDTO.setSign_type();
//        reqDTO.setBody("");
//        reqDTO.setDetail();
//        reqDTO.setOut_trade_no();
//        reqDTO.setFee_type();
//        reqDTO.setTotal_fee();
//        reqDTO.setSpbill_create_ip();
//        reqDTO.setNonce_str();
//        reqDTO.setTrade_type();
//        reqDTO.setOpenid();
//        TreeMap treeMap = new TreeMap(JSONObject.parseObject(JSONObject.toJSONString(reqDTO)));
//        HttpHeaders headers = new HttpHeaders();
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//        map.putAll(treeMap);
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//        ResponseEntity<UnifiedOrderResDTO> responseEntity = restTemplate.postForEntity(UNIFIED_ORDER_URL, request, UnifiedOrderResDTO.class);
//        if (responseEntity.getStatusCode() != HttpStatus.OK) {
//            throw new BusinessRuntimeException("", "请求下单api异常");//TODO
//        }
//        UnifiedOrderResDTO resDTO = responseEntity.getBody();
//        if ((!SUCCESS.equals(resDTO.getReturn_code())) || (SUCCESS.equals(resDTO.getResult_code()))) {
//            throw new BusinessRuntimeException("", "");
//        }
//        //通信标识和交易标识都为成功 则为交易成功
//        return;
    }
}
