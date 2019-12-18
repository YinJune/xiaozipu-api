package com.xiaozipu.service.impl;

import com.xiaozipu.entity.LoanOrder;
import com.xiaozipu.mapper.LoanOrderMapper;
import com.xiaozipu.service.ILoanOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 借款订单 服务实现类
 * </p>
 *
 * @author along
 * @since 2018-12-06
 */
@Service
public class LoanOrderServiceImpl extends ServiceImpl<LoanOrderMapper, LoanOrder> implements ILoanOrderService {

}
