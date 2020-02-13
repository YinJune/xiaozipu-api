package com.xiaozipu.admin.banner;

import com.xiaozipu.admin.service.banner.BannerService;
import com.xiaozipu.dao.entity.generator.TBanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 16:42
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.xiaozipu"})
@MapperScan(basePackages = {"com.xiaozipu.dao.mapper"})
public class BannerTest {

    @Autowired
    private BannerService bannerService;

    @Test
    public void insertBannerTest(){
        TBanner banner=new TBanner();
        banner.setName("测试banner");
        banner.setBannerUrl("www.baidu.com");
        banner.setPosition("1");
        banner.setStatus("1");
        banner.setCreateTime(new Date());

        bannerService.insertBanner(banner);
    }
}
