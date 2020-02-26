package com.xiaozipu.client.service.order;

import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;
import com.xiaozipu.client.pojo.dto.order.ProductSpecQuantity;
import com.xiaozipu.client.service.address.AddressService;
import com.xiaozipu.client.service.payment.PaymentService;
import com.xiaozipu.client.service.product.ProductSpecService;
import com.xiaozipu.common.enums.ShopOrderStatusEnum;
import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.enums.serial.SerialNoTypeEnum;
import com.xiaozipu.common.util.SerialNoUtils;
import com.xiaozipu.dao.entity.generator.TOrder;
import com.xiaozipu.dao.entity.generator.TOrderProduct;
import com.xiaozipu.dao.entity.generator.TProductSpec;
import com.xiaozipu.dao.entity.generator.TUserAddress;
import com.xiaozipu.dao.mapper.generator.TOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private AddressService addressService;
    @Autowired
    private ProductSpecService productSpecService;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private PaymentService paymentService;

    /**
     * 计算金额
     *
     * @param calculateAmountDTO
     * @return
     */
    @Override
    public BigDecimal calculateAmount(CalculateAmountDTO calculateAmountDTO) {
        //日后可能会有优惠券、运费、折扣
        BigDecimal productAmount = productSpecService.calculateAmount(calculateAmountDTO.getProductSpecQuantityList());
        return productAmount;
    }

    /**
     * 下单
     *
     * @param placeOrderDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer placeOrder(Integer userId, PlaceOrderDTO placeOrderDTO) {
        TUserAddress address = addressService.getAddressById(placeOrderDTO.getAddressId());
        TOrder order = new TOrder();
        order.setOrderCode(SerialNoUtils.generateSerialNo(SerialNoTypeEnum.SHOP_ORDER));
        order.setUserId(userId);
        BigDecimal amount = calculateAmount(placeOrderDTO);
        order.setOrderAmount(amount);
        order.setPayAmount(amount);
        order.setRecipientName(address.getRecipientName());
        order.setRecipientPhone(address.getRecipientPhone());
        order.setRecipientAddress(address.getAddressDetail());
        order.setStatus(ShopOrderStatusEnum.NOT_PAY.getType());
        order.setPayStatus(StatusEnum.INVALID.getKey());
        order.setDeleted(StatusEnum.INVALID.getKey());
        orderMapper.insertSelective(order);
        List<TOrderProduct> orderProducts = new ArrayList<>();
        for (ProductSpecQuantity productSpecQuantity : placeOrderDTO.getProductSpecQuantityList()) {
            TProductSpec productSpecs = productSpecService.getProductSpecById(productSpecQuantity.getProductSpecId());
            TOrderProduct orderProduct = new TOrderProduct();
            orderProduct.setPrice(productSpecs.getPrice());
            orderProduct.setPayPrice(productSpecs.getPrice());
            orderProduct.setQuantity(productSpecQuantity.getQuantity());
            orderProduct.setProductSpecId(productSpecQuantity.getProductSpecId());
            orderProduct.setUserId(userId);
            orderProduct.setOrderId(order.getId());
            orderProducts.add(orderProduct);
        }
        orderProductService.batchInsert(orderProducts);
        //
        paymentService.unifiedOrder(order);
        return order.getId();
    }
}
