package com.xiaozipu.admin.service.oss;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 18:20
 * @description:
 */
public interface OssService {
    /**
     * 上传文件
     *
     * @param bytes
     * @return
     */
    String uploadFile(String name, byte[] bytes);
}
