package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.merchant.service.oss.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 18:18
 * @description:
 */
@RestController
public class OssController {

    @Autowired
    private OssService ossService;

    /**
     * 上传文件
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @PostMapping("/aliyun/oss/file/upload")
    public ResultInfo uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        ResultInfo resultInfo = new ResultInfo();
        String requestId = ossService.uploadFile(multipartFile.getOriginalFilename(), multipartFile.getBytes());
        resultInfo.setData(requestId);
        return resultInfo;
    }
}
