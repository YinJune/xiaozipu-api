package com.xiaozipu.merchant.web;

import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.merchant.pojo.dto.spec.AddSpecNameReqDTO;
import com.xiaozipu.merchant.pojo.dto.spec.AddSpecValueReqDTO;
import com.xiaozipu.merchant.service.spec.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YinJunJie
 * @date: 2020/1/21 13:49
 * @description:
 */
@RestController
public class SpecController {
    @Autowired
    private SpecService specService;

    /**
     * 添加一个规格名
     *
     * @param addSpecNameReqDto
     * @return
     */
    @PostMapping("/spec/add/name")
    public ResultInfo addSpecName(@RequestBody AddSpecNameReqDTO addSpecNameReqDto) {
        ResultInfo resultInfo = new ResultInfo();
        Integer specId = specService.addSpecName(addSpecNameReqDto);
        resultInfo.setData(specId);
        return resultInfo;
    }

    /**
     * 添加一个规格值
     *
     * @param addSpecValueReqDto
     * @return
     */
    @PostMapping("/spec/add/value")
    public ResultInfo addSpecValue(@RequestBody AddSpecValueReqDTO addSpecValueReqDto) {
        ResultInfo resultInfo = new ResultInfo();
        Integer valueId = specService.addSpecValue(addSpecValueReqDto);
        resultInfo.setData(valueId);
        return resultInfo;
    }

    /**
     * 删除规格名
     *
     * @param specId
     * @return
     */
    @PostMapping("/spec/delete/name/{specId}")
    public ResultInfo deleteSpecName(@PathVariable Integer specId) {
        ResultInfo resultInfo = new ResultInfo();
        specService.deleteSpecName(specId);
        return resultInfo;
    }

    /**
     * 删除规格值
     *
     * @param valueId
     * @return
     */
    @PostMapping("/spec/delete/value/{valueId}")
    public ResultInfo deleteSpecValue(@PathVariable Integer valueId) {
        ResultInfo resultInfo = new ResultInfo();
        specService.deleteSpecValue(valueId);
        return resultInfo;
    }
}
