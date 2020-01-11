package com.xiaozipu.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 22:48
 * @description:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaozipu"})
@MapperScan(basePackages = {"com.xiaozipu.dao.mapper"})
public class XzpMerchantApplication {
    public static void main(String[] args) {
        SpringApplication.run(XzpMerchantApplication.class,args);
    }
}
