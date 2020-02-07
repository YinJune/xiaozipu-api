package com.xiaozipu.client.service.index;

import com.xiaozipu.client.pojo.vo.BannerVO;
import com.xiaozipu.client.pojo.vo.IndexVO;
import com.xiaozipu.client.pojo.vo.ProductSummaryVO;
import com.xiaozipu.client.service.banner.BannerService;
import com.xiaozipu.client.service.product.ProductService;
import com.xiaozipu.client.service.product.RecommendProductService;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.entity.generator.TBanner;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 16:10
 * @description:
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private ProductService productService;
    @Autowired
    private RecommendProductService recommendProductService;
    @Autowired
    private BannerService bannerService;


    /**
     * 首页数据
     *
     * @return
     */
    @Override
    public IndexVO getIndexData() {
        List<TBanner> banners = bannerService.listBannerByPosition("INDEX");
        List<BannerVO> bannerVOList = new ArrayList<>();
        BeanUtils.copyProperties(banners, bannerVOList);
        List<ProductSummaryDO> rankingListProducts = productService.getRankingList(1, "2");
        List<ProductSummaryDO> recommendProducts = recommendProductService.listRecommendProduct(1);
        IndexVO indexVO = new IndexVO();
        indexVO.setBannerList(bannerVOList);
        List<ProductSummaryVO> rankListProductSummaryVoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(rankingListProducts)) {
            BeanUtils.copyProperties(rankingListProducts, rankListProductSummaryVoList);
        }
        List<ProductSummaryVO> recommendProductVoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(recommendProducts)) {
            BeanUtils.copyProperties(recommendProducts, recommendProductVoList);
        }
        indexVO.setRankListProductList(rankListProductSummaryVoList);
        indexVO.setRecommendProductList(recommendProductVoList);
        return indexVO;
    }
}
