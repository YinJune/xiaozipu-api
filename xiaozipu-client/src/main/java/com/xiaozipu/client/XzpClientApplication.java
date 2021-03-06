package com.xiaozipu.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaozipu"})
@MapperScan(basePackages = {"com.xiaozipu.dao.mapper","com.xiaozipu.client.dao.mapper"})
public class XzpClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(XzpClientApplication.class, args);
    }
}
