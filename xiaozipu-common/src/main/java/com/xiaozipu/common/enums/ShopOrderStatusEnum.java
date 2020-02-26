package com.xiaozipu.common.enums;

/**
 * @author: YinJunJie
 * @date: 2020/2/26 16:58
 * @description:
 */
public enum ShopOrderStatusEnum {
    //订单状态 1：待支付；2：已支付待发货；3：已发货未收货；4：已确认收货；5：申请退货中；6：退货已同意；7：退货已拒绝；
    NOT_PAY("01", "待支付"),
    PAID("02", "已支付待发货"),
    DELIVERED("03", "已发货待收货"),
    RECEIVED("04", "已确认收货"),
    REFUNDING("05", "申请退货中"),
    REFUND_APPROVED("06", "退货已同意"),
    REFUND_REFUSED("07", "退货已拒绝");
    private String type;
    private String desc;

    ShopOrderStatusEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
