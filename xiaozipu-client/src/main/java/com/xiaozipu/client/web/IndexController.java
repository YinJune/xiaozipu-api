package com.xiaozipu.client.web;

import com.xiaozipu.client.pojo.vo.IndexVO;
import com.xiaozipu.client.service.index.IndexService;
import com.xiaozipu.common.result.ResultInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/13 15:33
 * @description:
 */
@Api(tags = "首页")
@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     * 首页数据
     *
     * @return
     */
    @GetMapping("/anon/index/all/data")
    public ResultInfo getIndexData() {
        ResultInfo resultInfo = new ResultInfo();
        IndexVO indexVO = indexService.getIndexData();
        resultInfo.setData(indexVO);
        return resultInfo;
    }

    @GetMapping("/anon/test")
    public ResultInfo test(){
        return new ResultInfo();
    }
}
