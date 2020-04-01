package com.xiaozipu.client.service.address;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.client.pojo.dto.AddressDTO;
import com.xiaozipu.client.pojo.vo.AddressVO;
import com.xiaozipu.common.exception.BusinessRuntimeException;
import com.xiaozipu.common.util.BeanCopyUtils;
import com.xiaozipu.dao.entity.*;
import com.xiaozipu.dao.mapper.TCityMapper;
import com.xiaozipu.dao.mapper.TDistrictMapper;
import com.xiaozipu.dao.mapper.TProvinceMapper;
import com.xiaozipu.dao.mapper.TUserAddressMapper;
import org.springframework.beans.BeanUtils;
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
    public List<AddressVO> getAddressesByUserId(Integer userId) {
        TUserAddressExample example = new TUserAddressExample();
        example.createCriteria().andUserIdEqualTo(userId).andDeletedEqualTo(StatusEnum.INVALID.getKey());
        List<TUserAddress> addressList=addressMapper.selectByExample(example);
       List<AddressVO> addressVOS= BeanCopyUtils.copyListProperties(addressList,AddressVO::new,(address,addressVO)->{
            addressVO.setProvinceWord(convertProvince(address.getProvince()));
            addressVO.setCityWord(convertCity(address.getCity()));
            addressVO.setDistrictWord(convertDistrict(address.getDistrict()));
        });
        return addressVOS ;
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
        BeanUtils.copyProperties(addressDTO,address);
        address.setUserId(userId);
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
        BeanUtils.copyProperties(addressDTO,address);
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
    public String convertProvince(String provinceCode) {
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
    public String convertCity(String cityCode) {
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
    public String convertDistrict(String districtCode) {
        TDistrictExample example = new TDistrictExample();
        example.createCriteria().andCodeEqualTo(districtCode);
        List<TDistrict> districts = districtMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(districts)) {
            throw new BusinessRuntimeException("", "城市编码非法");
        }
        return districts.get(0).getDistrict();
    }

    /**
     * 默认地址
     *
     * @param userId
     * @return
     */
    @Override
    public TUserAddress getDefaultAddress(Integer userId) {
        TUserAddressExample example=new TUserAddressExample();
        example.createCriteria().andIsDefaultEqualTo(StatusEnum.VALID.getKey()).andDeletedEqualTo(StatusEnum.INVALID.getKey());
        List<TUserAddress> addresses=addressMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(addresses)){
            return null;
        }
        return addresses.get(0);
    }

    @Override
    public TUserAddress getAddressesById(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
