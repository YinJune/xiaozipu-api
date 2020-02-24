package com.xiaozipu.client.service.order;

import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.service.product.ProductSpecService;
import com.xiaozipu.dao.entity.generator.TOrder;
import com.xiaozipu.dao.mapper.generator.TOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 14:25
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    private TOrderMapper orderMapper;
    @Autowired
    private ProductSpecService productSpecService;

    /**
     * 计算金额
     *
     * @param calculateAmountDTO
     * @return
     */
    @Override
    public BigDecimal calculateAmount(CalculateAmountDTO calculateAmountDTO) {
        //日后可能会有优惠券、运费、折扣
        BigDecimal productAmount = productSpecService.calculateAmount(calculateAmountDTO.getProductSpecIds());
        return productAmount;
    }

    /**
     * 下单
     *
     * @param calculateAmountDTO
     * @return
     */
    @Override
    public Integer placeOrder(Integer userId, CalculateAmountDTO calculateAmountDTO) {
        TOrder order = new TOrder();
        order.setOrderCode("");
        order.setUserId(userId);
        BigDecimal amount = calculateAmount(calculateAmountDTO);
        order.setAmount(amount);
        order.setPayAmount(amount);

        return null;
    }
}
