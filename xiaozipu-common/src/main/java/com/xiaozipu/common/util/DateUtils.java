package com.xiaozipu.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final Logger log= LoggerFactory.getLogger(DateUtils.class);

    /**
     * 字串转为日期
     *
     * @param dateStr
     * @return
     */
    public static Date getDateFromString(String dateStr) {
        return getDateFromString(dateStr, null);
    }

    /**
     * 字串转为日期
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date getDateFromString(String dateStr, String pattern) {
        if ((pattern == null) || ("".equals(pattern))) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }

    /**
     * 字串转为日期
     *
     * @param dateStr
     * @param pattern
     * @param locale
     * @return
     */
    public static Date getDateFromString(String dateStr, String pattern, Locale locale) {
        if ((pattern == null) || ("".equals(pattern))) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
        Date date;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }

    /**
     * 日期转为字串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getStrFromDate(Date date, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        String s = df.format(date);
        return s;
    }


    /**
     * 日期转字串
     *
     * @param date
     * @return
     */
    public static String getLongStrFromDate(Date date) {
        return getStrFromDate(date, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 增加月份
     *
     * @param date
     * @param month
     * @return
     */
    public static Date addMonth(Date date, int month) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }


    /**
     * 指定日期加上一个值
     *
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static Date optTime(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 返回两个日期时间差 ms
     *
     * @param first
     * @param second
     * @return
     */
    public static long distance(Date first, Date second) {
        return second.getTime() - first.getTime();
    }

    /**
     * 时间差s
     *
     * @param first
     * @param second
     * @return
     */
    public static int distanceSec(Date first, Date second) {
        Long sec = Long.valueOf((second.getTime() - first.getTime()) / 1000L);
        return sec.intValue();
    }

    /**
     * 返回时间差m
     *
     * @param first
     * @param second
     * @return
     */
    public static int distanceMin(Date first, Date second) {
        return distanceSec(first, second) / 60;
    }

    /**
     * 返回时间差h
     *
     * @param first
     * @param second
     * @return
     */
    public static int distanceHour(Date first, Date second) {
        return distanceMin(first, second) / 60;
    }

    /**
     * 返回时间差d
     *
     * @param first
     * @param second
     * @return
     */
    public static int distanceDay(Date first, Date second) {
        return distanceHour(first, second) / 24;
    }

    /**
     * 返回时间差d
     *
     * @param first
     * @param second
     * @return
     */
    public static int distanceDay(String first, Date second) {
        return distanceHour(getDateFromString(first), second) / 24;
    }

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }



    public static boolean isValidDate(String timeStr,String formatStr) {
        boolean convertSuccess=true;
//　　　　　// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            format.setLenient(false);
            format.parse(timeStr);
        } catch (ParseException e) {
            // e.printStackTrace();
        // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return convertSuccess;
    }

    /**
     * 严格限制日期格式
     * @param dateStr
     * @param datePattern
     * @return
     */
    public static boolean isRightDateStr(String dateStr,String datePattern){
        DateFormat dateFormat  = new SimpleDateFormat(datePattern);
        try {
            //采用严格的解析方式，防止类似 “2017-05-35” 类型的字符串通过
            dateFormat.setLenient(false);
            dateFormat.parse(dateStr);
            Date date = (Date)dateFormat.parse(dateStr);
            //重复比对一下，防止类似 “2017-5-15” 类型的字符串通过
            String newDateStr = dateFormat.format(date);
            if(dateStr.equals(newDateStr)){
                return true;
            }else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     *
     * @param dateTime
     * @return
     */
    public static String localDateTimeToStr(LocalDateTime dateTime) {
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (dateTime == null)
            dateTime = LocalDateTime.now();
        String str = dateTime.format(df);
        log.info("localDateTimeToStr:{}", str);
        return str;
    }

    /**
     *
     * @param dateTime
     * @return
     */
    public static String localDateTimeToYms(LocalDateTime dateTime) {
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        if (dateTime == null)
            dateTime = LocalDateTime.now();
        String str = dateTime.format(df);
        log.info("localDateTimeToStr:{}", str);
        return str;
    }

    /**
     * localdate to str(yyyy-MM-dd)
     * @param date
     * @return
     */
    public static String localDateToStr(LocalDate date) {
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (date == null)
            date = LocalDate.now();
        String str = date.format(df);
        log.info("localDateToStr:{}", str);
        return str;
    }

    public static void main(String[] args) {
//        boolean rightDateStr = isRightDateStr("2018-07-30", "yyyy-MM-dd");
//        boolean rightDateStr2 = isRightDateStr("2018-07-30 17:47:41", "yyyy-MM-dd");
//        System.out.println(rightDateStr);
//        System.out.println(rightDateStr2);
        log.info(localDateTimeToYms(null));
    }

}