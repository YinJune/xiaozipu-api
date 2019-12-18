package com.xiaozipu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 借款订单
 * </p>
 *
 * @author along
 * @since 2018-12-06
 */
public class LoanOrder extends Model<LoanOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long paramSettingId;
    /**
     * 订单号码
     */
    private String orderNumber;
    /**
     * 连连支付商户打款订单号
     */
    private String lianPayNum;
    /**
     * 连连支付用户还款单号
     */
    private String lianRepayNum;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 银行卡号
     */
    private String bankCardNum;
    private Double interestPrecent;
    /**
     * 借款期限（天）
     */
    private Integer limitDays;
    /**
     * 借款金额
     */
    private BigDecimal borrowMoney;
    /**
     * 到账金额
     */
    private BigDecimal realMoney;
    /**
     * 利息
     */
    private BigDecimal interestMoney;
    /**
     * 平台服务费
     */
    private BigDecimal placeServeMoney;
    /**
     * 信息认证费
     */
    private BigDecimal msgAuthMoney;
    /**
     * 风控服务费
     */
    private BigDecimal riskServeMoney;
    /**
     * 风险准备金
     */
    private BigDecimal riskPlanMoney;
    /**
     * 综合费用
     */
    private BigDecimal wateMoney;
    /**
     * 优惠卷节省金额
     */
    private BigDecimal saveMoney;
    /**
     * 应还金额
     */
    private BigDecimal needPayMoney;
    /**
     * 实还金额
     */
    private BigDecimal realPayMoney;
    /**
     * 借款时间
     */
    private LocalDateTime gmtDatetime;
    private LocalDateTime uptDateime;
    /**
     * 放款时间
     */
    private LocalDateTime passTime;
    /**
     * 打款时间
     */
    private LocalDateTime giveTime;
    /**
     * 应还款时间
     */
    private LocalDate limitPayTime;
    /**
     * 超出容限期时间
     */
    private LocalDate overdueTime;
    /**
     * 实际还款时间
     */
    private LocalDateTime realPayTime;
    private Long userCouponId;
    /**
     * 逾期天数
     */
    private Integer overdueDays;
    /**
     * 逾期金额
     */
    private BigDecimal overdueMoney;
    /**
     * 容限期
     */
    private BigDecimal allowDays;
    /**
     * 容限期费用
     */
    private BigDecimal allowMoney;
    /**
     * 审核员id
     */
    private Long auditorId;
    /**
     * 订单状态 默认0未申请    1审核中2待打款3待还款4容限期中5已超出容限期6已还款7审核失败8坏账9打款中10还款中11机审拒绝
     */
    private Integer orderStatus;
    /**
     * 打款状态0未打款1打款还未成功2打款成功3打款失败4退款状态
     */
    private Integer giveStatus;
    /**
     * 还款状态 1正常还款2逾期还款
     */
    private Integer payStatus;
    /**
     * 借款协议
     */
    private String agreementUrl;
    /**
     * 借款服务协议
     */
    private String agreementTwoUrl;
    /**
     * 会员协议
     */
    private String agreementThirdUrl;
    /**
     * 借款协议号
     */
    private String noAgree;
    /**
     * 还款计划编号
     */
    private String repaymentNo;
    /**
     * 协商款金额
     */
    private BigDecimal consultRepaymentMoney;
    /**
     * 催款员
     */
    private Long pressMoneyMan;
    private Integer extendNum;
    /**
     * 利润
     */
    private BigDecimal channelProfit;
    private String riskItems;
    /**
     * 同盾分
     */
    private String tdScore;
    /**
     * 1,续期2还款
     */
    private Integer type;
    /**
     * 支付请求号
     */
    private String requestNo;
    /**
     * 催收次数
     */
    private Integer pressTimes;
    /**
     * 最近一次催收时间
     */
    private LocalDate lastPressDate;
    /**
     * 自动扣款金额
     */
    private String autoPaymentMoney;
    /**
     * 线下部分还款
     */
    private BigDecimal belowPartPayment;
    /**
     * 机审状态：0审核成功 1审核失败
     */
    private String autoStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParamSettingId() {
        return paramSettingId;
    }

    public void setParamSettingId(Long paramSettingId) {
        this.paramSettingId = paramSettingId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getLianPayNum() {
        return lianPayNum;
    }

    public void setLianPayNum(String lianPayNum) {
        this.lianPayNum = lianPayNum;
    }

    public String getLianRepayNum() {
        return lianRepayNum;
    }

    public void setLianRepayNum(String lianRepayNum) {
        this.lianRepayNum = lianRepayNum;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardNum() {
        return bankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        this.bankCardNum = bankCardNum;
    }

    public Double getInterestPrecent() {
        return interestPrecent;
    }

    public void setInterestPrecent(Double interestPrecent) {
        this.interestPrecent = interestPrecent;
    }

    public Integer getLimitDays() {
        return limitDays;
    }

    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
    }

    public BigDecimal getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(BigDecimal borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    public BigDecimal getInterestMoney() {
        return interestMoney;
    }

    public void setInterestMoney(BigDecimal interestMoney) {
        this.interestMoney = interestMoney;
    }

    public BigDecimal getPlaceServeMoney() {
        return placeServeMoney;
    }

    public void setPlaceServeMoney(BigDecimal placeServeMoney) {
        this.placeServeMoney = placeServeMoney;
    }

    public BigDecimal getMsgAuthMoney() {
        return msgAuthMoney;
    }

    public void setMsgAuthMoney(BigDecimal msgAuthMoney) {
        this.msgAuthMoney = msgAuthMoney;
    }

    public BigDecimal getRiskServeMoney() {
        return riskServeMoney;
    }

    public void setRiskServeMoney(BigDecimal riskServeMoney) {
        this.riskServeMoney = riskServeMoney;
    }

    public BigDecimal getRiskPlanMoney() {
        return riskPlanMoney;
    }

    public void setRiskPlanMoney(BigDecimal riskPlanMoney) {
        this.riskPlanMoney = riskPlanMoney;
    }

    public BigDecimal getWateMoney() {
        return wateMoney;
    }

    public void setWateMoney(BigDecimal wateMoney) {
        this.wateMoney = wateMoney;
    }

    public BigDecimal getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(BigDecimal saveMoney) {
        this.saveMoney = saveMoney;
    }

    public BigDecimal getNeedPayMoney() {
        return needPayMoney;
    }

    public void setNeedPayMoney(BigDecimal needPayMoney) {
        this.needPayMoney = needPayMoney;
    }

    public BigDecimal getRealPayMoney() {
        return realPayMoney;
    }

    public void setRealPayMoney(BigDecimal realPayMoney) {
        this.realPayMoney = realPayMoney;
    }

    public LocalDateTime getGmtDatetime() {
        return gmtDatetime;
    }

    public void setGmtDatetime(LocalDateTime gmtDatetime) {
        this.gmtDatetime = gmtDatetime;
    }

    public LocalDateTime getUptDateime() {
        return uptDateime;
    }

    public void setUptDateime(LocalDateTime uptDateime) {
        this.uptDateime = uptDateime;
    }

    public LocalDateTime getPassTime() {
        return passTime;
    }

    public void setPassTime(LocalDateTime passTime) {
        this.passTime = passTime;
    }

    public LocalDateTime getGiveTime() {
        return giveTime;
    }

    public void setGiveTime(LocalDateTime giveTime) {
        this.giveTime = giveTime;
    }

    public LocalDate getLimitPayTime() {
        return limitPayTime;
    }

    public void setLimitPayTime(LocalDate limitPayTime) {
        this.limitPayTime = limitPayTime;
    }

    public LocalDate getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(LocalDate overdueTime) {
        this.overdueTime = overdueTime;
    }

    public LocalDateTime getRealPayTime() {
        return realPayTime;
    }

    public void setRealPayTime(LocalDateTime realPayTime) {
        this.realPayTime = realPayTime;
    }

    public Long getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(Long userCouponId) {
        this.userCouponId = userCouponId;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public BigDecimal getOverdueMoney() {
        return overdueMoney;
    }

    public void setOverdueMoney(BigDecimal overdueMoney) {
        this.overdueMoney = overdueMoney;
    }

    public BigDecimal getAllowDays() {
        return allowDays;
    }

    public void setAllowDays(BigDecimal allowDays) {
        this.allowDays = allowDays;
    }

    public BigDecimal getAllowMoney() {
        return allowMoney;
    }

    public void setAllowMoney(BigDecimal allowMoney) {
        this.allowMoney = allowMoney;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getGiveStatus() {
        return giveStatus;
    }

    public void setGiveStatus(Integer giveStatus) {
        this.giveStatus = giveStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getAgreementUrl() {
        return agreementUrl;
    }

    public void setAgreementUrl(String agreementUrl) {
        this.agreementUrl = agreementUrl;
    }

    public String getAgreementTwoUrl() {
        return agreementTwoUrl;
    }

    public void setAgreementTwoUrl(String agreementTwoUrl) {
        this.agreementTwoUrl = agreementTwoUrl;
    }

    public String getAgreementThirdUrl() {
        return agreementThirdUrl;
    }

    public void setAgreementThirdUrl(String agreementThirdUrl) {
        this.agreementThirdUrl = agreementThirdUrl;
    }

    public String getNoAgree() {
        return noAgree;
    }

    public void setNoAgree(String noAgree) {
        this.noAgree = noAgree;
    }

    public String getRepaymentNo() {
        return repaymentNo;
    }

    public void setRepaymentNo(String repaymentNo) {
        this.repaymentNo = repaymentNo;
    }

    public BigDecimal getConsultRepaymentMoney() {
        return consultRepaymentMoney;
    }

    public void setConsultRepaymentMoney(BigDecimal consultRepaymentMoney) {
        this.consultRepaymentMoney = consultRepaymentMoney;
    }

    public Long getPressMoneyMan() {
        return pressMoneyMan;
    }

    public void setPressMoneyMan(Long pressMoneyMan) {
        this.pressMoneyMan = pressMoneyMan;
    }

    public Integer getExtendNum() {
        return extendNum;
    }

    public void setExtendNum(Integer extendNum) {
        this.extendNum = extendNum;
    }

    public BigDecimal getChannelProfit() {
        return channelProfit;
    }

    public void setChannelProfit(BigDecimal channelProfit) {
        this.channelProfit = channelProfit;
    }

    public String getRiskItems() {
        return riskItems;
    }

    public void setRiskItems(String riskItems) {
        this.riskItems = riskItems;
    }

    public String getTdScore() {
        return tdScore;
    }

    public void setTdScore(String tdScore) {
        this.tdScore = tdScore;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Integer getPressTimes() {
        return pressTimes;
    }

    public void setPressTimes(Integer pressTimes) {
        this.pressTimes = pressTimes;
    }

    public LocalDate getLastPressDate() {
        return lastPressDate;
    }

    public void setLastPressDate(LocalDate lastPressDate) {
        this.lastPressDate = lastPressDate;
    }

    public String getAutoPaymentMoney() {
        return autoPaymentMoney;
    }

    public void setAutoPaymentMoney(String autoPaymentMoney) {
        this.autoPaymentMoney = autoPaymentMoney;
    }

    public BigDecimal getBelowPartPayment() {
        return belowPartPayment;
    }

    public void setBelowPartPayment(BigDecimal belowPartPayment) {
        this.belowPartPayment = belowPartPayment;
    }

    public String getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(String autoStatus) {
        this.autoStatus = autoStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LoanOrder{" +
        ", id=" + id +
        ", userId=" + userId +
        ", paramSettingId=" + paramSettingId +
        ", orderNumber=" + orderNumber +
        ", lianPayNum=" + lianPayNum +
        ", lianRepayNum=" + lianRepayNum +
        ", bankName=" + bankName +
        ", bankCardNum=" + bankCardNum +
        ", interestPrecent=" + interestPrecent +
        ", limitDays=" + limitDays +
        ", borrowMoney=" + borrowMoney +
        ", realMoney=" + realMoney +
        ", interestMoney=" + interestMoney +
        ", placeServeMoney=" + placeServeMoney +
        ", msgAuthMoney=" + msgAuthMoney +
        ", riskServeMoney=" + riskServeMoney +
        ", riskPlanMoney=" + riskPlanMoney +
        ", wateMoney=" + wateMoney +
        ", saveMoney=" + saveMoney +
        ", needPayMoney=" + needPayMoney +
        ", realPayMoney=" + realPayMoney +
        ", gmtDatetime=" + gmtDatetime +
        ", uptDateime=" + uptDateime +
        ", passTime=" + passTime +
        ", giveTime=" + giveTime +
        ", limitPayTime=" + limitPayTime +
        ", overdueTime=" + overdueTime +
        ", realPayTime=" + realPayTime +
        ", userCouponId=" + userCouponId +
        ", overdueDays=" + overdueDays +
        ", overdueMoney=" + overdueMoney +
        ", allowDays=" + allowDays +
        ", allowMoney=" + allowMoney +
        ", auditorId=" + auditorId +
        ", orderStatus=" + orderStatus +
        ", giveStatus=" + giveStatus +
        ", payStatus=" + payStatus +
        ", agreementUrl=" + agreementUrl +
        ", agreementTwoUrl=" + agreementTwoUrl +
        ", agreementThirdUrl=" + agreementThirdUrl +
        ", noAgree=" + noAgree +
        ", repaymentNo=" + repaymentNo +
        ", consultRepaymentMoney=" + consultRepaymentMoney +
        ", pressMoneyMan=" + pressMoneyMan +
        ", extendNum=" + extendNum +
        ", channelProfit=" + channelProfit +
        ", riskItems=" + riskItems +
        ", tdScore=" + tdScore +
        ", type=" + type +
        ", requestNo=" + requestNo +
        ", pressTimes=" + pressTimes +
        ", lastPressDate=" + lastPressDate +
        ", autoPaymentMoney=" + autoPaymentMoney +
        ", belowPartPayment=" + belowPartPayment +
        ", autoStatus=" + autoStatus +
        "}";
    }
}
