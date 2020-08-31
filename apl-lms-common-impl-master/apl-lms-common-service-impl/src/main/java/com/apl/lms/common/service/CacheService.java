package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtil;

public interface CacheService {

    ResultUtil<Boolean> addCountryCache(String codes);

    ResultUtil<Boolean> addAirCarrierCache(String keys, Long minKey, Long maxKey);

    ResultUtil<Boolean> addAirPortCache(String codes);

    ResultUtil<Boolean> addSeaPortCache(String keys, Long minKey, Long maxKey);

    ResultUtil<Boolean> addSeaCarrierCache(String keys, Long maxKey, Long minKey);

    ResultUtil<Boolean> addCommodityUnitCache(String keys, Long maxKey, Long minKey);

    ResultUtil<Boolean> addSpecialCommodityCache(String keys, Long maxKey, Long minKey);

    ResultUtil<Boolean> addSurchargeCache(String keys, Long maxKey, Long minKey);
}
