package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/2/13 21:02
 * @description:
 */
@RestController
public class TestController {

    @GetMapping("/anon/test")
    public ResultInfo test() {
        return new ResultInfo();
    }
}
