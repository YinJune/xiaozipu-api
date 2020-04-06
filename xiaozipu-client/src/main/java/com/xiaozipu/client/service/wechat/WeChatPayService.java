package com.xiaozipu.client.service.wechat;

import com.xiaozipu.client.pojo.dto.mp.UnifiedOrderResDTO;
import com.xiaozipu.client.pojo.vo.UnifiedOrderResVO;
import com.xiaozipu.dao.entity.TOrder;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 23:09
 * @description:
 */
public interface WeChatPayService {
    /**
     * 微信支付统一下单
     *
     * @param order
     */
    UnifiedOrderResVO unifiedOrder(TOrder order) throws Exception;
}
