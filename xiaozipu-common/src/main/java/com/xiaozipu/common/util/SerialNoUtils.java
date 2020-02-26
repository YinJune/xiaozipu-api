package com.xiaozipu.common.util;

import com.xiaozipu.common.enums.serial.SerialNoTypeEnum;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SerialNoUtils {
    private static long orderNum = 0L;
    private static String date;


    /**
     * 生成流水号 定长 22位
     *
     * @return
     */
    public static synchronized String generateSerialNo(SerialNoTypeEnum serialNoTypeEnum) {
        //17位时间标志
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        //加订单类型 加3位随机数
        String serialNo = str + serialNoTypeEnum.getType() + RandomUtils.randomString(3);
        return serialNo;
    }

}
