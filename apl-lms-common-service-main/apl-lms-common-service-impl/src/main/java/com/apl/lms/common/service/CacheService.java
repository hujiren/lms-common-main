package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtils;

public interface CacheService {

    ResultUtils<Boolean> addCountryCache(String codes);

    ResultUtils<Boolean> addAirCarrierCache(String keys, Long minKey, Long maxKey);

    ResultUtils<Boolean> addAirPortCache(String codes);

    ResultUtils<Boolean> addSeaPortCache(String keys, Long minKey, Long maxKey);

    ResultUtils<Boolean> addSeaCarrierCache(String keys, Long maxKey, Long minKey);

    ResultUtils<Boolean> addCommodityUnitCache(String keys, Long maxKey, Long minKey);
}
