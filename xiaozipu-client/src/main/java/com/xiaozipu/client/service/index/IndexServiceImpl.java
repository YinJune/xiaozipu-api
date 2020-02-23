package com.xiaozipu.client.service.index;

import com.xiaozipu.client.pojo.vo.BannerVO;
import com.xiaozipu.client.pojo.vo.IndexVO;
import com.xiaozipu.client.pojo.vo.product.ProductSummaryVO;
import com.xiaozipu.client.service.banner.BannerService;
import com.xiaozipu.client.service.product.ProductService;
import com.xiaozipu.client.service.product.RecommendProductService;
import com.xiaozipu.common.enums.banner.BannerPositionEnum;
import com.xiaozipu.common.enums.product.OrderTypeEnum;
import com.xiaozipu.common.enums.product.SortTypeEnum;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.entity.generator.TBanner;
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
        if (!CollectionUtils.isEmpty(banners)) {
            bannerVOList = BeanCopyUtils.copyListProperties(banners, BannerVO::new);
        }
        //排行榜
        List<ProductSummaryDO> rankingListProducts = productService.getProductList(1, SortTypeEnum.SALES_VOLUME.getType(), OrderTypeEnum.DESC.getType(), null);
        List<ProductSummaryVO> rankListProductSummaryVoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(rankingListProducts)) {
            rankListProductSummaryVoList = BeanCopyUtils.copyListProperties(rankingListProducts, ProductSummaryVO::new);
        }
        //推荐商品
        List<ProductSummaryDO> recommendProducts = recommendProductService.listRecommendProduct(1);
        List<ProductSummaryVO> recommendProductVoList = new ArrayList<>();
        if (CollectionUtils.isEmpty(recommendProducts)) {
            recommendProductVoList = BeanCopyUtils.copyListProperties(recommendProducts, ProductSummaryVO::new);
        }
        IndexVO indexVO = new IndexVO();
        indexVO.setBannerList(bannerVOList);
        indexVO.setRankListProductList(rankListProductSummaryVoList);
        indexVO.setRecommendProductList(recommendProductVoList);
        return indexVO;
    }
}
