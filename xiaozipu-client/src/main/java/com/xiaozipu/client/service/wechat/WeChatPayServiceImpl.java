package com.xiaozipu.client.service.wechat;

import com.xiaozipu.dao.entity.generator.TOrder;
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
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 微信支付统一下单
     *
     * @param order
     */
    @Override
    public void unifiedOrder(TOrder order) {
//        restTemplate.postForEntity();
    }
}
