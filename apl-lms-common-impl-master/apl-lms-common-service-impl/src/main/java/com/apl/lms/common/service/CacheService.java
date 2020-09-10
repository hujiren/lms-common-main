package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtil;

public interface CacheService {

    ResultUtil<Boolean> addCountryCache(String keys);

    ResultUtil<Boolean> addAirCarrierCache(String keys);

    ResultUtil<Boolean> addAirPortCache(String codes);

    ResultUtil<Boolean> addSeaPortCache(String keys);

    ResultUtil<Boolean> addSeaCarrierCache(String keys);

    ResultUtil<Boolean> addCommodityUnitCache(String keys);

    ResultUtil<Boolean> addSpecialCommodityCache(String keys);

    ResultUtil<Boolean> addSurchargeCache(String keys);

    ResultUtil<Boolean> addWeightWayCache(String keys);
}
