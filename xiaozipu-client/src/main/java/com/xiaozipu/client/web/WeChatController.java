package com.xiaozipu.client.web;

import com.xiaozipu.client.utils.WechatSignUtils;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.service.wechat.WeChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/22 10:17
 */
@RestController
public class WeChatController {

    private static Logger logger=LoggerFactory.getLogger(WeChatController.class);

    @Autowired
    private WeChatService weChatService;

    /**
     * 解密微信数据 如wx.getUserInfo返回数据
     *
     * @return
     */
    @PostMapping("/anon/wechat/data/decrypt")
    public ResultInfo decryptUserInfo() {
        ResultInfo resultInfo = new ResultInfo();
        weChatService.decryptUserInfo();
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
