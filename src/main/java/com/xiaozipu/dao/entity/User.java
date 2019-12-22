package com.xiaozipu.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Long id;

    private Date gmtDatetime;

    private Date uptDatetime;

    private String uuid;

    private String userName;

    private String password;

    private String headImg;

    private String phone;

    private BigDecimal money;

    private Integer userType;

    private Integer authStatus;

    private String token;

    private Integer status;

    private String payPwd;

    private Integer authScore;

    private String phoneSign;

    private Integer isPay;

    private Integer couponAllCount;

    private Integer couponUseCount;

    private Integer couponPastCount;

    private Date refuseRemoveTime;

    private Integer isOld;

    private Integer bankauthNum;

    private Long channelId;

    private String channelName;

    private String openId;

    private Integer isXuqi;

    private Integer overdueTimes;

    private Integer loanTimes;

    private Integer pressTimes;

    private Long adminAuditId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtDatetime() {
        return gmtDatetime;
    }

    public void setGmtDatetime(Date gmtDatetime) {
        this.gmtDatetime = gmtDatetime;
    }

    public Date getUptDatetime() {
        return uptDatetime;
    }

    public void setUptDatetime(Date uptDatetime) {
        this.uptDatetime = uptDatetime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    public Integer getAuthScore() {
        return authScore;
    }

    public void setAuthScore(Integer authScore) {
        this.authScore = authScore;
    }

    public String getPhoneSign() {
        return phoneSign;
    }

    public void setPhoneSign(String phoneSign) {
        this.phoneSign = phoneSign == null ? null : phoneSign.trim();
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getCouponAllCount() {
        return couponAllCount;
    }

    public void setCouponAllCount(Integer couponAllCount) {
        this.couponAllCount = couponAllCount;
    }

    public Integer getCouponUseCount() {
        return couponUseCount;
    }

    public void setCouponUseCount(Integer couponUseCount) {
        this.couponUseCount = couponUseCount;
    }

    public Integer getCouponPastCount() {
        return couponPastCount;
    }

    public void setCouponPastCount(Integer couponPastCount) {
        this.couponPastCount = couponPastCount;
    }

    public Date getRefuseRemoveTime() {
        return refuseRemoveTime;
    }

    public void setRefuseRemoveTime(Date refuseRemoveTime) {
        this.refuseRemoveTime = refuseRemoveTime;
    }

    public Integer getIsOld() {
        return isOld;
    }

    public void setIsOld(Integer isOld) {
        this.isOld = isOld;
    }

    public Integer getBankauthNum() {
        return bankauthNum;
    }

    public void setBankauthNum(Integer bankauthNum) {
        this.bankauthNum = bankauthNum;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getIsXuqi() {
        return isXuqi;
    }

    public void setIsXuqi(Integer isXuqi) {
        this.isXuqi = isXuqi;
    }

    public Integer getOverdueTimes() {
        return overdueTimes;
    }

    public void setOverdueTimes(Integer overdueTimes) {
        this.overdueTimes = overdueTimes;
    }

    public Integer getLoanTimes() {
        return loanTimes;
    }

    public void setLoanTimes(Integer loanTimes) {
        this.loanTimes = loanTimes;
    }

    public Integer getPressTimes() {
        return pressTimes;
    }

    public void setPressTimes(Integer pressTimes) {
        this.pressTimes = pressTimes;
    }

    public Long getAdminAuditId() {
        return adminAuditId;
    }

    public void setAdminAuditId(Long adminAuditId) {
        this.adminAuditId = adminAuditId;
    }
}