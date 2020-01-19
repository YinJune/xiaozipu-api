package com.xiaozipu.service.product;

import com.github.pagehelper.PageHelper;
import com.xiaozipu.dao.entity.custom.ProductSummaryDO;
import com.xiaozipu.dao.mapper.custom.ProductDao;
import com.xiaozipu.dao.mapper.generator.TProductMapper;
import com.xiaozipu.service.enums.RankingListTypeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/12 12:11
 * @description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private TProductMapper productMapper;
    @Resource
    private ProductDao productDao;

    /**
     * 根据商品id查询商品简要信息
     *
     * @param productId
     * @return
     */
    @Override
    public ProductSummaryDO getProductSummaryBoById(Integer productId) {
        return productDao.getProductSummaryById(productId);
//        ProductSummaryVO productSummaryVO =new ProductSummaryVO();
//        if (productSummaryDO!=null){
//            BeanUtils.copyProperties(productSummaryDO, productSummaryVO);
//        }
//        return productSummaryVO;
    }

    /**
     * 排行榜
     *
     * @param currentPage
     * @param type
     * @return
     */
    @Override
    public List<ProductSummaryDO> getRankingList(Integer currentPage, String type) {
        PageHelper.startPage(currentPage,10);
        List<com.xiaozipu.dao.entity.custom.ProductSummaryDO> productSummaryDOList=null;
        if (RankingListTypeEnum.TIME.getKey().equals(type)){
            productSummaryDOList=productDao.getProductList("create_time");
        }else {
            //TODO 销量排名
            productSummaryDOList=productDao.getProductList("create_time");
        }

        return productSummaryDOList;
    }
}
