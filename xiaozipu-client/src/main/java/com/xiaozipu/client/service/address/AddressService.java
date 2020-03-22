package com.xiaozipu.client.service.address;

import com.xiaozipu.client.pojo.dto.AddressDTO;
import com.xiaozipu.client.pojo.vo.AddressVO;
import com.xiaozipu.dao.entity.TUserAddress;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 15:48
 * @description:
 */
public interface AddressService {
    /**
     * 获取用户地址列表
     *
     * @param userId
     * @return
     */
    List<AddressVO> getAddressesByUserId(Integer userId);

    /**
     * 添加收货地址
     *
     * @param userId
     * @param addressDTO
     */
    void addAddress(Integer userId, AddressDTO addressDTO);

    /**
     * 修改收货地址
     *
     * @param addressDTO
     */
    void updateAddress(AddressDTO addressDTO);

    /**
     * 根据id查询地址
     *
     * @param addressId
     * @return
     */
    TUserAddress getAddressById(Integer addressId);

    /**
     * 默认地址
     * @param userId
     * @return
     */
    TUserAddress getDefaultAddress(Integer userId);

    TUserAddress getAddressesById(Integer addressId);
    String convertProvince(String provinceCode) ;
    String convertCity(String cityCode) ;
    String convertDistrict(String districtCode) ;
}
