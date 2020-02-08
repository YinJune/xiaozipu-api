package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.service.mp.MpService;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/2/8 11:08
 * @description:
 */
@RestController
public class MpController {
    private static final Logger logger = LoggerFactory.getLogger(MpController.class);
    @Autowired
    private MpService mpService;

    /**
     * 小程序登陆
     *
     * @return
     */
    @GetMapping("/anon/wechat/mini/login")
    public ResultInfo miniLogin(@RequestParam("jsCode") String jsCode) {
        logger.info("小程序登陆:jsCode={}", jsCode);
        ResultInfo resultInfo = new ResultInfo();
        JSONObject jsonObject = mpService.miniLogin(jsCode);
        resultInfo.setData(jsonObject);
        return resultInfo;
    }

}
