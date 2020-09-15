/*
 * Copyright © 2018 BDHub Software
 * Shenzhen BDHub Software Co., Ltd.
 * http://www.bdhubware.com/
 * All rights reserved.
 */

package com.apl.lms.common.mapper;


import com.apl.lms.common.lib.cache.bo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author APL
 * @since 2019-10-14
 */
@Repository
public interface CacheMapper extends BaseMapper {

    //添加国家缓存
    @MapKey("cacheKey")
    Map<String, CountryCacheBo> addCountryCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, AirCarrierCacheBo> addAirCarrierCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, AirPortCacheBo> addAirPortCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, SeaPortCacheBo> addSeaPortCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, SeaCarrierCacheBo> addSeaCarrierCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, CommodityUnitCacheBo> addCommodityUnitCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, SpecialCommodityCacheBo> addSpecialCommodityCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, SurchargeCacheBo> addSurchargeCache(@Param("keys") String keys);

    @MapKey("cacheKey")
    Map<String, WeightWayCacheBo> addWeightWayCache(@Param("keys") String keys);
}

