package com.xiaozipu.client.service.order;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.client.dao.entity.CartProductDO;
import com.xiaozipu.client.dao.entity.ProductSummaryDO;
import com.xiaozipu.client.dao.mapper.OrderDao;
import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;
import com.xiaozipu.client.pojo.dto.order.ProductSpecQuantity;
import com.xiaozipu.client.pojo.vo.AddressVO;
import com.xiaozipu.client.pojo.vo.order.ConfirmOrderInfoVO;
import com.xiaozipu.client.pojo.vo.product.CartProductVO;
import com.xiaozipu.client.pojo.vo.product.ProductSummaryVO;
import com.xiaozipu.client.service.address.AddressService;
import com.xiaozipu.client.service.cart.ShoppingCartService;
import com.xiaozipu.client.service.payment.PaymentService;
import com.xiaozipu.client.service.product.ProductService;
import com.xiaozipu.client.service.product.ProductSpecService;
import com.xiaozipu.common.enums.ShopOrderStatusEnum;
import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.enums.serial.SerialNoTypeEnum;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.common.util.MoneyUtils;
import com.xiaozipu.common.util.SerialNoUtils;
import com.xiaozipu.client.dao.entity.OrderDetailDO;
import com.xiaozipu.client.dao.entity.OrderListDO;
import com.xiaozipu.dao.entity.*;
import com.xiaozipu.dao.mapper.TOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    @Resource
    private OrderDao orderDao;
    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private ProductService productService;

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
        //校验库存
        // 减库存 TODO

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
            TProductSpec productSpecs = productSpecService.getById(productSpecQuantity.getProductSpecId());
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
        paymentService.unifiedOrder(order);
        return order.getId();
    }

    /**
     * 订单列表
     *
     * @param userId
     * @param status
     * @param currentPage
     * @return
     */
    @Override
    public List<OrderListDO> getOrderList(Integer userId, String status, Integer currentPage) {
        PageHelper.startPage(currentPage, 10);
        return orderDao.getOrderList(userId, status);
    }

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDetailDO getOrderDetail(Integer orderId) {
        OrderDetailDO orderDetailDO = orderDao.getOrderDetail(orderId);
        return orderDetailDO;
    }

    /**
     * 确认订单页信息
     *
     * @param calculateAmountDTO
     * @return
     */
    @Override
    public ConfirmOrderInfoVO confirmOrderInfo(Integer userId, CalculateAmountDTO calculateAmountDTO) {
        TUserAddress address = addressService.getDefaultAddress(userId);
        AddressVO addressVO = new AddressVO();
        BeanUtils.copyProperties(address, addressVO);
        addressVO.setProvinceWord(addressService.convertProvince(address.getProvince()));
        addressVO.setCityWord(addressService.convertCity(address.getCity()));
        addressVO.setDistrictWord(addressService.convertDistrict(address.getDistrict()));
        BigDecimal orderAmount;
        List<CartProductVO> cartProductVOS;
        if (!CollectionUtils.isEmpty(calculateAmountDTO.getCartIds())) {
            //从购物车来
            orderAmount = cartService.calculateAmount(calculateAmountDTO.getCartIds());
            List<CartProductDO> cartProductDOS = cartService.batchGetProductSummary(calculateAmountDTO.getCartIds());
            cartProductVOS = BeanCopyUtils.copyListProperties(cartProductDOS, CartProductVO::new,(cartDO,cartVO)->{
                cartVO.setProductPrice(cartDO.getProductPrice().divide(MoneyUtils.UNIT));
            });
        } else {
            //从商品详情来  只可能有一个商品规格
            ProductSpecQuantity productSpecQuantity = calculateAmountDTO.getProductSpecQuantityList().get(0);
            Integer productSpecId = productSpecQuantity.getProductSpecId();
            orderAmount = calculateAmount(calculateAmountDTO);
            cartProductVOS = new ArrayList<>();
            TProductSpec productSpec = productSpecService.getById(productSpecId);
            ProductSummaryDO productSummaryDO=productService.getProductSummaryBoById(productSpec.getProductId());
            CartProductVO cartProductVO=new CartProductVO();
            cartProductVO.setProductSpecId(productSpecId);
            cartProductVO.setQuantity(productSpecQuantity.getQuantity());
            cartProductVO.setProductImageUrl(productSummaryDO.getProductImageUrl());
            cartProductVO.setProductName(productSummaryDO.getProductName());
            cartProductVO.setProductPrice(productSpec.getPrice().divide(MoneyUtils.UNIT));
            cartProductVO.setSummary(productSummaryDO.getSummary());
            cartProductVOS.add(cartProductVO);
        }
        ConfirmOrderInfoVO confirmOrderInfoVO = new ConfirmOrderInfoVO();
        confirmOrderInfoVO.setAddressVO(addressVO);
        confirmOrderInfoVO.setCartProductVOS(cartProductVOS);
        confirmOrderInfoVO.setOrderAmount(orderAmount.divide(MoneyUtils.UNIT));
        confirmOrderInfoVO.setPayAmount(orderAmount.divide(MoneyUtils.UNIT));
        return confirmOrderInfoVO;
    }
}
