package com.xiaozipu.client.service.order;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.client.dao.entity.CartProductDO;
import com.xiaozipu.client.dao.entity.ProductSummaryDO;
import com.xiaozipu.client.dao.mapper.OrderDao;
import com.xiaozipu.client.pojo.dto.mp.UnifiedOrderResDTO;
import com.xiaozipu.client.pojo.dto.order.CalculateAmountDTO;
import com.xiaozipu.client.pojo.dto.order.PlaceOrderDTO;
import com.xiaozipu.client.pojo.vo.AddressVO;
import com.xiaozipu.client.pojo.vo.UnifiedOrderResVO;
import com.xiaozipu.client.pojo.vo.order.ConfirmOrderInfoVO;
import com.xiaozipu.client.pojo.vo.product.CartProductVO;
import com.xiaozipu.client.service.address.AddressService;
import com.xiaozipu.client.service.cart.ShoppingCartService;
import com.xiaozipu.client.service.payment.PaymentService;
import com.xiaozipu.client.service.product.ProductService;
import com.xiaozipu.client.service.product.ProductSpecService;
import com.xiaozipu.common.enums.PayTypeEnum;
import com.xiaozipu.common.enums.ShopOrderStatusEnum;
import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.enums.serial.SerialNoTypeEnum;
import com.xiaozipu.common.exception.BusinessRuntimeException;
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
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

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
        //校验参数
        if (StringUtils.isEmpty(calculateAmountDTO.getCartIds())&&calculateAmountDTO.getProductSpecId()==null){
            throw new BusinessRuntimeException("","参数错误");
        }
        //日后可能会有优惠券、运费、折扣
        BigDecimal productAmount = BigDecimal.ZERO;
        if (StringUtils.isEmpty(calculateAmountDTO.getCartIds())) {
            //
            productAmount = productSpecService.calculateAmount(calculateAmountDTO.getProductSpecId(), calculateAmountDTO.getQuantity());
        } else {
            productAmount = cartService.calculateAmount(calculateAmountDTO.getCartIds());
        }
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
    public UnifiedOrderResVO placeOrder(Integer userId, PlaceOrderDTO placeOrderDTO) {
        //校验参数
        if (StringUtils.isEmpty(placeOrderDTO.getCartIds())&&placeOrderDTO.getProductSpecId()==null){
            throw new BusinessRuntimeException("","参数错误");
        }
        //校验并减库存
        reduceStock(placeOrderDTO);

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
        for (Integer cartId : placeOrderDTO.getCartIds()) {
            TShoppingCartProduct cartProduct = cartService.getById(cartId);
            TProductSpec productSpecs = productSpecService.getById(cartProduct.getProductSpecId());
            TOrderProduct orderProduct = new TOrderProduct();
            orderProduct.setPrice(productSpecs.getPrice());
            orderProduct.setPayPrice(productSpecs.getPrice());
            orderProduct.setQuantity(cartProduct.getQuantity());
            orderProduct.setProductSpecId(cartProduct.getProductSpecId());
            orderProduct.setUserId(userId);
            orderProduct.setOrderId(order.getId());
            orderProducts.add(orderProduct);
        }
        orderProductService.batchInsert(orderProducts);
        UnifiedOrderResDTO unifiedOrderResDTO = paymentService.unifiedOrder(order);
        UnifiedOrderResVO unifiedOrderResVO = new UnifiedOrderResVO();
        unifiedOrderResVO.setNonce_str(unifiedOrderResDTO.getNonce_str());
        unifiedOrderResVO.setPackageStr("prepay_id=" + unifiedOrderResDTO.getPrepay_id());
        return unifiedOrderResVO;
    }

    /**
     * 先这样写吧
     *
     * @param placeOrderDTO
     */
    @Transactional(rollbackFor = Exception.class)
    public void reduceStock(PlaceOrderDTO placeOrderDTO) {
        if (CollectionUtils.isEmpty(placeOrderDTO.getCartIds())) {
            //商品详情过来
            TProductSpec productSpec = productSpecService.getById(placeOrderDTO.getProductSpecId());
            if (productSpec.getStock() < placeOrderDTO.getQuantity()) {
                throw new BusinessRuntimeException("", "库存不足");
            }
            productSpec.setStock(productSpec.getStock() - placeOrderDTO.getQuantity());
            productSpecService.updateProductSpec(productSpec);
        } else {
            List<TShoppingCartProduct> shoppingCartProducts = cartService.listByIds(placeOrderDTO.getCartIds());
            Map<Integer, Integer> productMap = new HashMap<>();
            List<Integer> productSpecIds = new ArrayList<>();
            for (TShoppingCartProduct product : shoppingCartProducts) {
                productMap.put(product.getProductSpecId(), product.getQuantity());
                productSpecIds.add(product.getProductSpecId());
            }
            List<TProductSpec> productSpecs = productSpecService.listProductSpec(productSpecIds);
            for (TProductSpec productSpec : productSpecs) {
                if (productSpec.getStock() < productMap.get(productSpec.getId())) {
                    throw new BusinessRuntimeException("", "库存不足");
                }
                productSpec.setStock(productSpec.getStock() - placeOrderDTO.getQuantity());
            }
            productSpecService.batchUpdateProductSpec(productSpecs);
        }
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
            cartProductVOS = BeanCopyUtils.copyListProperties(cartProductDOS, CartProductVO::new, (cartDO, cartVO) -> {
                cartVO.setProductPrice(cartDO.getProductPrice().divide(MoneyUtils.UNIT));
            });
        } else {
            //从商品详情来  只可能有一个商品规格
            TProductSpec productSpec = productSpecService.getById(calculateAmountDTO.getProductSpecId());
            orderAmount = productSpec.getPrice().divide(MoneyUtils.UNIT).multiply(new BigDecimal(calculateAmountDTO.getQuantity()));
            cartProductVOS = new ArrayList<>();
            ProductSummaryDO productSummaryDO = productService.getProductSummaryBoById(productSpec.getProductId());
            CartProductVO cartProductVO = new CartProductVO();
            cartProductVO.setProductSpecId(calculateAmountDTO.getProductSpecId());
            cartProductVO.setQuantity(calculateAmountDTO.getQuantity());
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

    /**
     * 根据code查询订单
     *
     * @param orderCode
     * @return
     */
    @Override
    public TOrder getOrderByCode(String orderCode) {
        TOrderExample example=new TOrderExample();
        example.createCriteria().andOrderCodeEqualTo(orderCode);
        return orderMapper.selectOneByExample(example);
    }

    /**
     * 支付成功
     *
     * @param orderCode
     */
    @Override
    public void paySuccess(String orderCode) {
        TOrder order=getOrderByCode(orderCode);
        order.setPayStatus(StatusEnum.VALID.getKey());
        order.setPayTime(new Date());
        order.setPayType(PayTypeEnum.WX.getKey());
        orderMapper.updateByPrimaryKeySelective(order);
    }
}
