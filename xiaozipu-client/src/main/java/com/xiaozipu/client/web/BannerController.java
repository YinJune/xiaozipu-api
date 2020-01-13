package com.xiaozipu.client.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Banner相关接口")
@RestController
public class BannerController {

//    @Autowired
//    private BannerService bannerService;
//
//    /**
//     * 根据位置查询banner
//     *
//     * @param position
//     * @return
//     */
//    @ApiOperation(value = "首页顶部Banner查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "position",value = "banner位置",required = true,paramType = "form")
//    })
//    @GetMapping("/banner/list")
//    public ResultInfo listBannerByPosition(@RequestParam("position") String position) {
//        List<TBanner> bannerList = bannerService.listBannerByPosition(position);
//        ResultInfo resultInfo = new ResultInfo();
//        List<BannerResDTO> bannerResDTOS=new ArrayList<>();
//        BeanUtils.copyProperties(bannerList,bannerResDTOS);
//        resultInfo.setData(bannerResDTOS);
//        return resultInfo;
//    }
}
