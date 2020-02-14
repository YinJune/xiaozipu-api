package com.xiaozipu.merchant;

import com.xiaozipu.merchant.pojo.dto.product.recommend.AddRecommendProductReqDTO;
import com.xiaozipu.merchant.service.product.RecommendProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 16:33
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
    public void batchInsert() {
        AddRecommendProductReqDTO addRecommendProductReqDTO = new AddRecommendProductReqDTO();
        List<Integer> productIds = new ArrayList<>();
        productIds.add(1);
        productIds.add(2);
        productIds.add(3);
        addRecommendProductReqDTO.setProductIds(productIds);
        recommendProductService.insertRecommendProduct(addRecommendProductReqDTO);
    }
}
