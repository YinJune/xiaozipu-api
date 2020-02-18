package com.xiaozipu.client.service.index;

import com.xiaozipu.client.enums.ProductListSortTypeEnum;
import com.xiaozipu.client.pojo.vo.BannerVO;
import com.xiaozipu.client.pojo.vo.IndexVO;
import com.xiaozipu.client.pojo.vo.ProductSummaryVO;
import com.xiaozipu.client.service.banner.BannerService;
import com.xiaozipu.client.service.product.ProductService;
import com.xiaozipu.client.service.product.RecommendProductService;
import com.xiaozipu.common.enums.banner.BannerPositionEnum;
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
        //banner
        List<TBanner> banners = bannerService.listBannerByPosition(BannerPositionEnum.INDEX_TOP.getPosition());
        List<BannerVO> bannerVOList = new ArrayList<>();
        for (TBanner banner : banners) {
            BannerVO bannerVO = new BannerVO();
            BeanUtils.copyProperties(banner, bannerVO);
            bannerVOList.add(bannerVO);
        }
//        BeanUtils.copyProperties(banners, bannerVOList);
        //排行榜
        List<ProductSummaryDO> rankingListProducts = productService.getProductList(1, ProductListSortTypeEnum.SALES_VOLUME.getKey());
        List<ProductSummaryVO> rankListProductSummaryVoList = new ArrayList<>();
        for (ProductSummaryDO productSummaryDO : rankingListProducts) {
            ProductSummaryVO productSummaryVO = new ProductSummaryVO();
            BeanUtils.copyProperties(productSummaryDO, productSummaryVO);
            rankListProductSummaryVoList.add(productSummaryVO);
        }
        //推荐商品
        List<ProductSummaryDO> recommendProducts = recommendProductService.listRecommendProduct(1);
        List<ProductSummaryVO> recommendProductVoList = new ArrayList<>();
        for (ProductSummaryDO productSummaryDO : recommendProducts) {
            ProductSummaryVO productSummaryVO = new ProductSummaryVO();
            BeanUtils.copyProperties(productSummaryDO, productSummaryVO);
            recommendProductVoList.add(productSummaryVO);
        }
        IndexVO indexVO = new IndexVO();
        indexVO.setBannerList(bannerVOList);
        if (!CollectionUtils.isEmpty(rankingListProducts)) {
            BeanUtils.copyProperties(rankingListProducts, rankListProductSummaryVoList);
        }
        if (!CollectionUtils.isEmpty(recommendProducts)) {
            BeanUtils.copyProperties(recommendProducts, recommendProductVoList);
        }
        indexVO.setRankListProductList(rankListProductSummaryVoList);
        indexVO.setRecommendProductList(recommendProductVoList);
        return indexVO;
    }
}
