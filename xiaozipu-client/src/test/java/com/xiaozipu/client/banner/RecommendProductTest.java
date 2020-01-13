package com.xiaozipu.client.banner;

import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.service.domain.vo.ProductSummaryVO;
import com.xiaozipu.service.product.RecommendProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 16:47
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.xiaozipu"})
@MapperScan(basePackages = {"com.xiaozipu.dao.mapper"})
public class RecommendProductTest {
    @Autowired
    private RecommendProductService recommendProductService;

    @Test
    public void getRecommendProduct(){
        List<ProductSummaryDO> productSummaryDOList = recommendProductService.listRecommendProduct(1);
        System.out.println(productSummaryDOList);
    }
}
