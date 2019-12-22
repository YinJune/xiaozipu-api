//package com.xiaozipu.utils;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PropertiesLoaderUtils;
//
//import java.io.IOException;
//import java.utils.Properties;
//
//@Slf4j
//public class PropertiesUtil {
//
//    private static final String DEFAULT_PROPERTIES = "application.properties";
//
//    public static String prop(String str) {
//
//        try {
//            String properties = "application-" + propInit("spring.profiles.active").trim() + ".properties";
//            Resource resource = new ClassPathResource(properties);
//            Properties props = PropertiesLoaderUtils.loadProperties(resource);
//            return props.getProperty(str);
//        } catch (IOException e) {
//            log.error("", e);
//        }
//        return null;
//    }
//
//    /**
//     * 获取properties属性值
//     *
//     * @param str
//     * @return
//     */
//    public static String propInit(String str) {
//        try {
//            Resource resource = new ClassPathResource(DEFAULT_PROPERTIES);
//            Properties props = PropertiesLoaderUtils.loadProperties(resource);
//            return props.getProperty(str);
//        } catch (IOException e) {
//            log.error("", e);
//        }
//        return null;
//    }
//
//    /**
//     * @param str
//     * @return
//     */
//    public static Integer propInteger(String str) {
//        try {
//            String properties = "application-" + propInit("spring.profiles.active").trim() + ".properties";
//            Resource resource = new ClassPathResource(properties);
//            Properties props = PropertiesLoaderUtils.loadProperties(resource);
//            String propStr = props.getProperty(str);
//            if (StringUtils.isNotBlank(propStr)) {
//                return Integer.parseInt(propStr);
//            }
//        } catch (IOException e) {
//            log.error("", e);
//        }
//        return 0;
//    }
//
//
//}