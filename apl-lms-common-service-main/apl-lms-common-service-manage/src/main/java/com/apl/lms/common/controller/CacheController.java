package com.apl.lms.common.controller;

import com.apl.lib.utils.ResultUtils;
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
    public ResultUtils<Boolean> addCountryCache(@RequestParam("keys") String codes){

        return cacheService.addCountryCache(codes);
    }


    @PostMapping(value = "/add-air-carrier-cache")
    @ApiOperation(value = "添加航空公司缓存")
    public ResultUtils<Boolean> addAirCarrierCache(@RequestParam("keys") String keys,
                                                   @RequestParam("minKey") Long minKey,
                                                   @RequestParam("maxKey") Long maxKey){

        return cacheService.addAirCarrierCache(keys, minKey, maxKey);
    }


    @PostMapping(value = "/add-air-port-cache")
    @ApiOperation(value = "添加机场缓存")
    public ResultUtils<Boolean> addAirPortCache(@RequestParam("keys") String codes){
        return cacheService.addAirPortCache(codes);
    }


    @PostMapping(value = "/add-sea-port-cache")
    @ApiOperation(value = "添加港口缓存")
    public ResultUtils<Boolean> addSeaPortCache(@RequestParam("keys") String keys,
                                                @RequestParam("minKey") Long minKey,
                                                @RequestParam("maxKey") Long maxKey){
        return cacheService.addSeaPortCache(keys, maxKey, minKey);
    }


    @PostMapping(value = "/add-sea-carrier-cache")
    @ApiOperation(value = "添加船舶公司缓存")
    public ResultUtils<Boolean> addSeaCarrierCache(@RequestParam("keys") String keys,
                                                @RequestParam("minKey") Long minKey,
                                                @RequestParam("maxKey") Long maxKey){
        return cacheService.addSeaCarrierCache(keys, maxKey, minKey);
    }


    @PostMapping(value = "/add-commodity-unit-cache")
    @ApiOperation(value = "添加单位管理缓存")
    public ResultUtils<Boolean> addCommodityUnitCache(@RequestParam("keys") String keys,
                                                   @RequestParam("minKey") Long minKey,
                                                   @RequestParam("maxKey") Long maxKey){
        return cacheService.addCommodityUnitCache(keys, maxKey, minKey);
    }
}
