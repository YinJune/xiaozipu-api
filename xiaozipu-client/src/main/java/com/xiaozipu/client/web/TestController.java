package com.xiaozipu.client.web;

import com.xiaozipu.client.pojo.dto.CaptchaLoginDTO;
import com.xiaozipu.common.result.ResultInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/2/23 19:30
 * @description:
 */
@RestController
public class TestController {

    @GetMapping("/anon/test")
    public ResultInfo test() {
        return new ResultInfo();
    }

    @PostMapping("/anon/test/param")
    public ResultInfo test2(@RequestBody @Validated CaptchaLoginDTO captchaLoginDTO) {
        return new ResultInfo();
    }
}
