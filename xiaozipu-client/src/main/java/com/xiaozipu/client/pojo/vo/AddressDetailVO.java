package com.xiaozipu.client.pojo.vo;

import lombok.Data;

/**
 * @author: YinJunJie
 * @date: 2020/2/21 16:04
 * @description:
 */
@Data
public class AddressDetailVO extends AddressVO{
   private String provinceWord;
   private String cityWord;
   private String districtWord;
}
