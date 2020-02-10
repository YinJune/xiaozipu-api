package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.pojo.dto.mp.DecryptUserInfoReqDTO;
import com.xiaozipu.client.pojo.vo.UserInfoVo;
import com.xiaozipu.client.service.mp.MpService;
import com.xiaozipu.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 小程序登陆
     *
     * @return
     */
    @PostMapping("/anon/wechat/mini/decrypt")
    public ResultInfo decryptData(@RequestBody DecryptUserInfoReqDTO decryptUserInfoReqDTO) {
        logger.info("小程序解密数据:decryptUserInfoReqDTO={}", JSONObject.toJSONString(decryptUserInfoReqDTO));
        ResultInfo resultInfo = new ResultInfo();
        UserInfoVo userInfoVo = mpService.decryptData(decryptUserInfoReqDTO);
        resultInfo.setData(userInfoVo);
        return resultInfo;
    }
}
