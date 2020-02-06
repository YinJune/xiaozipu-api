package com.xiaozipu.third.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.third.service.MpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: YinJunJie
 * @date: 2020/2/6 10:52
 * @description:
 */
@RestController
public class MpController {

    private static Logger logger= LoggerFactory.getLogger(MpController.class);

    @Autowired
    private MpService mpService;

    /**
     * 小程序登陆
     *
     * @return
     */
    @PostMapping("/anon/wechat/mini/login")
    public ResultInfo miniLogin(@RequestBody String jsCode) {
        ResultInfo resultInfo = new ResultInfo();
        JSONObject jsonObject=mpService.miniLogin(jsCode);
        resultInfo.setData(jsonObject);
        return resultInfo;
    }

    /**
     * 解密微信数据 如wx.getUserInfo返回数据
     *
     * @return
     */
    @PostMapping("/anon/wechat/data/decrypt")
    public ResultInfo decryptUserInfo(@RequestBody String encryptedData) {
        ResultInfo resultInfo = new ResultInfo();
        mpService.decryptMpData(encryptedData);
        return resultInfo;
    }


    /**
     * 确认请求来自微信服务器
     */
    @RequestMapping(value = "/anon/wechat/echostr")
    public void doGet(HttpServletRequest request) {
        logger.info("确认请求来自微信服务...");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 区分小程序
//        String wxChannel = request.getParameter("wxChannel");
//        if (WechatSignUtils.checkSignature())
    }
}
