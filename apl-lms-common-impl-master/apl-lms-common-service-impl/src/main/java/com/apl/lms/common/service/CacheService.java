package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtil;

import java.io.IOException;

public interface CacheService {

    ResultUtil<Boolean> addCountryCache(String keys) throws IOException;

    ResultUtil<Boolean> addAirCarrierCache(String keys) throws IOException;

    ResultUtil<Boolean> addAirPortCache(String codes) throws IOException;

    ResultUtil<Boolean> addSeaPortCache(String keys) throws IOException;

    ResultUtil<Boolean> addSeaCarrierCache(String keys) throws IOException;

    ResultUtil<Boolean> addCommodityUnitCache(String keys) throws IOException;

    ResultUtil<Boolean> addSpecialCommodityCache(String keys) throws IOException;

    ResultUtil<Boolean> addSurchargeCache(String keys) throws IOException;

    ResultUtil<Boolean> addWeightWayCache(String keys) throws IOException;
}
