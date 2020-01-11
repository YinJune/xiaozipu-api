package com.xiaozipu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 16:45
 * @description:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaozipu"})
@MapperScan(basePackages = {"com.xiaozipu.dao.mapper"})
public class XzpAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(XzpAdminApplication.class,args);
    }
}
