package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.pojo.dto.AddressDTO;
import com.xiaozipu.client.pojo.vo.AddressVO;
import com.xiaozipu.client.service.address.AddressService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.dao.entity.generator.TUserAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 15:46
 * @description:
 */
@RestController
public class AddressController {
    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    /**
     * 收货地址列表
     *
     * @param request
     * @return
     */
    @GetMapping("/user/address/list")
    public ResultInfo getUserAddressList(HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("收货地址列表:{}", userId);
        List<TUserAddress> addressList = addressService.getAddressesByUserId(userId);
        List<AddressVO> addressVOS = BeanCopyUtils.copyListProperties(addressList, AddressVO::new);
        resultInfo.setData(addressVOS);
        return resultInfo;
    }

    /**
     * 添加收货地址
     *
     * @param request
     * @return
     */
    @PostMapping("/user/address/add")
    public ResultInfo addAddress(HttpServletRequest request, @RequestBody AddressDTO addressDTO) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("添加收货地址:{}", userId);
        addressService.addAddress(userId, addressDTO);
        return resultInfo;
    }

    /**
     * 收货地址列表
     *
     * @param request
     * @return
     */
    @GetMapping("/user/address/update")
    public ResultInfo updateAddress(HttpServletRequest request, @RequestBody AddressDTO addressDTO) {
        ResultInfo resultInfo = new ResultInfo();
        logger.info("修改收货地址:{}", JSONObject.toJSONString(addressDTO));
        addressService.updateAddress(addressDTO);
        return resultInfo;
    }
}
