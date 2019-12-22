package com.xiaozipu.controller.weixin;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.thirdapi.weixin.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/22 10:17
 */
@RestController
public class WxController {
    @Autowired
    private WxService wxService;

    /**
     * 解密微信数据 如wx.getUserInfo返回数据
     *
     * @return
     */
    @PostMapping("/anon/weixin/data/decrypt")
    public ResultInfo decryptUserInfo() {
        ResultInfo resultInfo = new ResultInfo();
        wxService.decryptUserInfo();
        return resultInfo;
    }
}
