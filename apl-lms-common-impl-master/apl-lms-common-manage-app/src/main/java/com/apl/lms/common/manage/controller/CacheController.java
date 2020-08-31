package com.apl.lms.common.manage.controller;

import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.service.CacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
@Api(value = "缓存",tags = "缓存")
@Validated
public class CacheController {

    @Autowired
    CacheService cacheService;

    @PostMapping("/add-country-cache")
    @ApiOperation(value = "添加国家缓存")
    public ResultUtil<Boolean> addCountryCache(@RequestParam("keys") String codes){

        return cacheService.addCountryCache(codes);
    }


    @PostMapping(value = "/add-air-carrier-cache")
    @ApiOperation(value = "添加航空公司缓存")
    public ResultUtil<Boolean> addAirCarrierCache(@RequestParam("keys") String keys,
                                                   @RequestParam("minKey") Long minKey,
                                                   @RequestParam("maxKey") Long maxKey){

        return cacheService.addAirCarrierCache(keys, minKey, maxKey);
    }


    @PostMapping(value = "/add-air-port-cache")
    @ApiOperation(value = "添加机场缓存")
    public ResultUtil<Boolean> addAirPortCache(@RequestParam("keys") String codes){
        return cacheService.addAirPortCache(codes);
    }


    @PostMapping(value = "/add-sea-port-cache")
    @ApiOperation(value = "添加港口缓存")
    public ResultUtil<Boolean> addSeaPortCache(@RequestParam("keys") String keys,
                                                @RequestParam("minKey") Long minKey,
                                                @RequestParam("maxKey") Long maxKey){
        return cacheService.addSeaPortCache(keys, maxKey, minKey);
    }


    @PostMapping(value = "/add-sea-carrier-cache")
    @ApiOperation(value = "添加船舶公司缓存")
    public ResultUtil<Boolean> addSeaCarrierCache(@RequestParam("keys") String keys,
                                                @RequestParam("minKey") Long minKey,
                                                @RequestParam("maxKey") Long maxKey){
        return cacheService.addSeaCarrierCache(keys, maxKey, minKey);
    }


    @PostMapping(value = "/add-commodity-unit-cache")
    @ApiOperation(value = "添加单位管理缓存")
    public ResultUtil<Boolean> addCommodityUnitCache(@RequestParam("keys") String keys,
                                                   @RequestParam("minKey") Long minKey,
                                                   @RequestParam("maxKey") Long maxKey){
        return cacheService.addCommodityUnitCache(keys, maxKey, minKey);
    }

    @PostMapping(value = "/add-special-commodity-cache")
    @ApiOperation(value = "添加特殊物品缓存")
    public ResultUtil<Boolean> addSpecialCommodityCache(@RequestParam("keys") String keys,
                                                     @RequestParam("minKey") Long minKey,
                                                     @RequestParam("maxKey") Long maxKey){
        return cacheService.addSpecialCommodityCache(keys, maxKey, minKey);
    }

    @PostMapping(value = "/add-surcharge-cache")
    @ApiOperation(value = "添加附加费缓存")
    public ResultUtil<Boolean> addSurchargeCache(@RequestParam("keys") String keys,
                                                        @RequestParam("minKey") Long minKey,
                                                        @RequestParam("maxKey") Long maxKey){
        return cacheService.addSurchargeCache(keys, maxKey, minKey);
    }
}
