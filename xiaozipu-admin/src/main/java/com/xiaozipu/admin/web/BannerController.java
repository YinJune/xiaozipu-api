package com.xiaozipu.admin.web;

import com.xiaozipu.admin.dto.req.AddBannerReqDTO;
import com.xiaozipu.admin.service.banner.BannerService;
import com.xiaozipu.common.enums.banner.BannerStatusEnum;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.dao.entity.generator.TBanner;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/8 21:33
 * @description:
 */
@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @PostMapping("/banner/add")
    public ResultInfo insertBanner(@RequestBody @Validated AddBannerReqDTO addBannerReqDto) {
        TBanner banner = new TBanner();
        BeanUtils.copyProperties(addBannerReqDto, banner);
        banner.setStatus(BannerStatusEnum.VALID.getKey());
        bannerService.insertBanner(banner);
        return new ResultInfo();
    }
}
