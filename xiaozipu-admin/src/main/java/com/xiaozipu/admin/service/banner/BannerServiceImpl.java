package com.xiaozipu.admin.service.banner;

import com.xiaozipu.common.enums.banner.BannerStatusEnum;
import com.xiaozipu.dao.entity.TBanner;
import com.xiaozipu.dao.entity.TBannerExample;
import com.xiaozipu.dao.mapper.TBannerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/8
 * @description:
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Resource
    private TBannerMapper bannerMapper;

    /**
     * 根据位置查询banner
     *
     * @param position
     * @return
     */
    @Override
    public List<TBanner> listBannerByPosition(String position) {
        TBannerExample example = new TBannerExample();
        example.createCriteria().andPositionEqualTo(position).andStatusEqualTo(BannerStatusEnum.VALID.getKey());
        return bannerMapper.selectByExample(example);
    }

    /**
     * 插入banner
     *
     * @param banner
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBanner(TBanner banner) {
        bannerMapper.insertSelective(banner);
    }
}
