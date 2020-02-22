package com.xiaozipu.common.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.ByteArrayInputStream;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 17:55
 * @description:
 */
public class OssUtils {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static final String OSS_ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static final String ACCESS_KEY_ID = "LTAI4Fipvg9bzUaU3W8E8gu1";
    private static final String ACCESS_KEY_SECRET = "O3RZbt0XNK9J01LiFmXNWRIeASBFkl";
    private static final String BUCKET_NAME = "yinjune-ceshi";
    private static final String PREFIX = "https://yinjune-ceshi.oss-cn-beijing.aliyuncs.com/";

    /**
     * @param objectName 上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
     * @param content    上传内容的二进制
     * @return
     */
    public static String putObject(String objectName, byte[] content) {
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(OSS_ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
         ossClient.putObject(BUCKET_NAME, objectName, new ByteArrayInputStream(content));
//        ossClient.generatePresignedUrl(BUKCET_NAME,objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
        return PREFIX+objectName;
    }
}
