package com.xiaozipu.admin.service.oss;

import com.xiaozipu.common.util.OssUtils;
import org.springframework.stereotype.Service;

/**
 * @author: YinJunJie
 * @date: 2020/1/11 18:20
 * @description:
 */
@Service
public class OssServiceImpl implements OssService {

    /**
     * 上传文件
     *
     * @param bytes
     * @return
     */
    @Override
    public String uploadFile(String name, byte[] bytes) {
        return OssUtils.putObject("user/" + name, bytes);
    }
}
