package com.xiaozipu.admin.service.banner;


import com.xiaozipu.dao.entity.TBanner;

import java.util.List;

/**
 * @author:
 * @version: v1.0
 * @description: com.xiaozipu.service.banner
 * @date:2020/1/8
 */
public interface BannerService {
    /**
     * 根据位置查询banner
     *
     * @param position
     * @return
     */
    List<TBanner> listBannerByPosition(String position);

    /**
     * 插入banner
     *
     * @param banner
     */
    void insertBanner(TBanner banner);
}
