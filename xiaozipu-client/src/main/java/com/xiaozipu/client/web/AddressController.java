package com.xiaozipu.client.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaozipu.client.common.annotation.TraceLog;
import com.xiaozipu.client.pojo.dto.AddressDTO;
import com.xiaozipu.client.pojo.vo.AddressDetailVO;
import com.xiaozipu.client.pojo.vo.AddressVO;
import com.xiaozipu.client.service.address.AddressService;
import com.xiaozipu.common.result.ResultInfo;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.dao.entity.TUserAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @TraceLog
    @GetMapping("/user/address/list")
    public ResultInfo getUserAddressList(HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("收货地址列表:{}", userId);
        List<AddressVO> addressList = addressService.getAddressesByUserId(userId);
        resultInfo.setData(addressList);
        return resultInfo;
    }
   /**
     * 收货地址详情
     *
     * @param request
     * @return
     */
   @TraceLog
    @GetMapping("/user/address/detail")
    public ResultInfo getUserAddressDetail(HttpServletRequest request, @RequestParam("addressId")Integer addressId) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("收货地址列表:{}", userId);
        TUserAddress address = addressService.getAddressesById(addressId);
        AddressDetailVO addressVO=new AddressDetailVO();
        BeanUtils.copyProperties(address,addressVO);
        addressVO.setProvinceWord(addressService.convertProvince(addressVO.getProvince()));
        addressVO.setCityWord(addressService.convertCity(addressVO.getCity()));
        addressVO.setDistrictWord(addressService.convertDistrict(addressVO.getDistrict()));
        resultInfo.setData(addressVO);
        return resultInfo;
    }

    /**
     * 添加收货地址
     *
     * @param request
     * @return
     */
    @TraceLog
    @PostMapping("/user/address/add")
    public ResultInfo addAddress(HttpServletRequest request, @RequestBody AddressDTO addressDTO) {
        ResultInfo resultInfo = new ResultInfo();
        Integer userId = (Integer) request.getAttribute("userId");
        logger.info("添加收货地址:{}", JSONObject.toJSONString(addressDTO));
        addressService.addAddress(userId, addressDTO);
        return resultInfo;
    }

    /**
     * 收货地址列表
     *
     * @param request
     * @return
     */
    @TraceLog
    @PostMapping("/user/address/update")
    public ResultInfo updateAddress(HttpServletRequest request, @RequestBody AddressDTO addressDTO) {
        ResultInfo resultInfo = new ResultInfo();
        logger.info("修改收货地址:{}", JSONObject.toJSONString(addressDTO));
        addressService.updateAddress(addressDTO);
        return resultInfo;
    }
}
