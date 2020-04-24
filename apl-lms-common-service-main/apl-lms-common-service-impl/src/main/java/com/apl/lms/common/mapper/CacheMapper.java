/*
 * Copyright © 2018 BDHub Software
 * Shenzhen BDHub Software Co., Ltd.
 * http://www.bdhubware.com/
 * All rights reserved.
 */

package com.apl.lms.common.mapper;

import com.apl.lms.common.lib.cache.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author APL
 * @since 2019-10-14
 */
public interface CacheMapper extends BaseMapper {

    //添加仓库缓存
    @MapKey("cacheKey")
    Map<String, CountryCacheBo> addCountryCache(@Param("codes") String codes, @Param("innerOrgId") Long innerOrgId);

    @MapKey("cacheKey")
    Map<String, AirCarrierCacheBo> addAirCarrierCache(@Param("keys") String keys,
                                                      @Param("minKey") Long minKey, @Param("maxKey") Long maxKey, @Param("innerOrgId") Long innerOrgId);

    @MapKey("cacheKey")
    Map<String, AirPortCacheBo> addAirPortCache(@Param("codes") String codes, @Param("innerOrgId") Long innerOrgId);

    @MapKey("cacheKey")
    Map<String, SeaPortCacheBo> addSeaPortCache(@Param("keys") String keys,
                                                @Param("innerOrgId") Long innerOrgId,@Param("minKey") Long minKey, @Param("maxKey") Long maxKey);

    @MapKey("cacheKey")
    Map<String, SeaCarrierCacheBo> addSeaCarrierCache(@Param("keys") String keys,
                                                      @Param("innerOrgId") Long innerOrgId,@Param("minKey") Long minKey, @Param("maxKey") Long maxKey);

    @MapKey("cacheKey")
    Map<String, CommodityUnitCacheBo> addCommodityUnitCache(@Param("keys") String keys,
                                                            @Param("innerOrgId") Long innerOrgId,@Param("minKey") Long minKey, @Param("maxKey") Long maxKey);
}

