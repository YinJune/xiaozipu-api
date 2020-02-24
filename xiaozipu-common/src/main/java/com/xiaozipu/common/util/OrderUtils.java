package com.xiaozipu.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderUtils {
    private static long orderNum = 0L;
    private static String date;


    /**
     * 生成订单编号
     *
     * @return
     */
    public static synchronized String getOrderNo() {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if (date == null || !date.equals(str)) {
            date = str;
            orderNum = 0l;
        }
        orderNum++;
        //2020022422361900001218
        //2020022423101000001350
        long orderNo = Long.parseLong((date)) * 100000;
        orderNo += orderNum;
        return orderNo + RandomUtils.randomString(3);
    }

    public static void main(String[] args) {
        String orderNo = getOrderNo();
        System.out.println(orderNo);
    }

}
