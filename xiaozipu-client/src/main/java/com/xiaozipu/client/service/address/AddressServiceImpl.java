package com.xiaozipu.client.service.address;

import com.xiaozipu.client.enums.StatusEnum;
import com.xiaozipu.client.pojo.dto.AddressDTO;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.dao.entity.generator.*;
import com.xiaozipu.dao.mapper.generator.TCityMapper;
import com.xiaozipu.dao.mapper.generator.TDistrictMapper;
import com.xiaozipu.dao.mapper.generator.TProvinceMapper;
import com.xiaozipu.dao.mapper.generator.TUserAddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 15:49
 * @description:
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private TUserAddressMapper addressMapper;
    @Resource
    private TProvinceMapper provinceMapper;
    @Resource
    private TCityMapper cityMapper;
    @Resource
    private TDistrictMapper districtMapper;

    /**
     * 获取用户地址列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<TUserAddress> getAddressesByUserId(Integer userId) {
        TUserAddressExample example = new TUserAddressExample();
        example.createCriteria().andUserIdEqualTo(userId).andDeletedEqualTo(StatusEnum.INVALID.getKey());
        return addressMapper.selectByExample(example);
    }

    /**
     * 添加收货地址
     *
     * @param userId
     * @param addressDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addAddress(Integer userId, AddressDTO addressDTO) {
        TUserAddress address = new TUserAddress();
        address.setUserId(userId);
        address.setRecipientPhone(addressDTO.getRecipientMobile());
        address.setRecipientName(addressDTO.getRecipientName());
        address.setProvince(convertProvince(addressDTO.getProvince()));
        address.setCity(convertCity(addressDTO.getCity()));
        address.setDistrict(convertDistrict(addressDTO.getDistrict()));
        address.setAddressDetail(addressDTO.getAddressDetail());
        address.setIsDefault(addressDTO.getIsDefault());
        address.setDeleted(StatusEnum.INVALID.getKey());
        addressMapper.insertSelective(address);
    }

    /**
     * 修改收货地址
     *
     * @param addressDTO
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAddress(AddressDTO addressDTO) {
        TUserAddress address = addressMapper.selectByPrimaryKey(addressDTO.getId());
        address.setRecipientPhone(addressDTO.getRecipientMobile());
        address.setRecipientName(addressDTO.getRecipientName());
        address.setProvince(convertProvince(addressDTO.getProvince()));
        address.setCity(convertCity(addressDTO.getCity()));
        address.setDistrict(convertDistrict(addressDTO.getDistrict()));
        address.setAddressDetail(addressDTO.getAddressDetail());
        address.setIsDefault(addressDTO.getIsDefault());
        address.setDeleted(StatusEnum.INVALID.getKey());
        addressMapper.updateByPrimaryKey(address);
    }

    /**
     * 根据id查询地址
     *
     * @param addressId
     * @return
     */
    @Override
    public TUserAddress getAddressById(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    /**
     * 转换省份编码
     *
     * @param provinceCode
     * @return
     */
    private String convertProvince(String provinceCode) {
        TProvinceExample example = new TProvinceExample();
        example.createCriteria().andCodeEqualTo(provinceCode);
        List<TProvince> provinces = provinceMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(provinces)) {
            throw new BusinessRuntimeException("", "城市编码非法");
        }
        return provinces.get(0).getProvince();
    }

    /**
     * 转换省份编码
     *
     * @param cityCode
     * @return
     */
    private String convertCity(String cityCode) {
        TCityExample example = new TCityExample();
        example.createCriteria().andCodeEqualTo(cityCode);
        List<TCity> tCities = cityMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tCities)) {
            throw new BusinessRuntimeException("", "城市编码非法");
        }
        return tCities.get(0).getCity();
    }

    /**
     * 转换省份编码
     *
     * @param districtCode
     * @return
     */
    private String convertDistrict(String districtCode) {
        TDistrictExample example = new TDistrictExample();
        example.createCriteria().andCodeEqualTo(districtCode);
        List<TDistrict> districts = districtMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(districts)) {
            throw new BusinessRuntimeException("", "城市编码非法");
        }
        return districts.get(0).getDistrict();
    }
}
