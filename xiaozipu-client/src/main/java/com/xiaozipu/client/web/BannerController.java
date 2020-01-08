package com.xiaozipu.client.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.dao.entity.TBanner;
import com.xiaozipu.service.banner.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 根据位置查询banner
     *
     * @param position
     * @return
     */
    @GetMapping("/banner/list")
    public ResultInfo listBannerByPosition(@RequestParam("position") String position) {
        List<TBanner> bannerList = bannerService.listBannerByPosition(position);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(bannerList);
        return resultInfo;
    }
}
