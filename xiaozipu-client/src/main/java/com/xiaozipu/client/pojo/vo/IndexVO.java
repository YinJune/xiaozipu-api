package com.xiaozipu.client.pojo.vo;

import com.xiaozipu.client.pojo.vo.product.ProductSummaryVO;
import lombok.Data;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 16:11
 * @description:
 */
@Data
public class IndexVO {
    /**
     * banner
     */
    private List<BannerVO> bannerList;
    private BannerVO hotBanner;
    private BannerVO rankBanner;
    /**
     * 排行榜商品
     */
    private List<ProductSummaryVO> rankListProductList;
    /**
     * 推荐商品
     */
    private List<ProductSummaryVO> recommendProductList;
}
