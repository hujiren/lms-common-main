package com.apl.lms.common.service;

/**
 * 添加缓存  service层
 */

import com.apl.lib.utils.ResultUtil;

import java.io.IOException;

public interface CacheService {

    ResultUtil<Boolean> addCountryCache(String keys) throws IOException;//国家缓存

    ResultUtil<Boolean> addAirCarrierCache(String keys) throws IOException;//航空公司缓存

    ResultUtil<Boolean> addAirPortCache(String codes) throws IOException;//机场缓存

    ResultUtil<Boolean> addSeaPortCache(String keys) throws IOException;//海港缓存

    ResultUtil<Boolean> addSeaCarrierCache(String keys) throws IOException;//船公司缓存

    ResultUtil<Boolean> addCommodityUnitCache(String keys) throws IOException;//单位管理缓存

    ResultUtil<Boolean> addSpecialCommodityCache(String keys) throws IOException;//特殊物品缓存

    ResultUtil<Boolean> addSurchargeCache(String keys) throws IOException;//附加费缓存

    ResultUtil<Boolean> addWeightWayCache(String keys) throws IOException;//计泡方式缓存
}
