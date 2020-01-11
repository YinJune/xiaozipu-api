package com.xiaozipu.client.banner;

import com.xiaozipu.service.banner.BannerService;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 16:47
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.xiaozipu"})
@MapperScan(basePackages = {"com.xiaozipu.dao.mapper"})
public class BannerTest {
    @Autowired
    private BannerService bannerService;
}
