package com.apl.lms.common.mapper;

import com.apl.lms.common.lib.cache.bo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
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
@Mapper
public interface CacheMapper extends BaseMapper {

    //添加国家缓存
    @MapKey("cacheKey")
    Map<String, CountryCacheBo> addCountryCache(@Param("keys") String keys);

    //航空公司缓存
    @MapKey("cacheKey")
    Map<String, AirCarrierCacheBo> addAirCarrierCache(@Param("keys") String keys);

    //机场缓存
    @MapKey("cacheKey")
    Map<String, AirPortCacheBo> addAirPortCache(@Param("keys") String keys);

    //海港缓存
    @MapKey("cacheKey")
    Map<String, SeaPortCacheBo> addSeaPortCache(@Param("keys") String keys);

    //船公司缓存
    @MapKey("cacheKey")
    Map<String, SeaCarrierCacheBo> addSeaCarrierCache(@Param("keys") String keys);

    //单位管理缓存
    @MapKey("cacheKey")
    Map<String, CommodityUnitCacheBo> addCommodityUnitCache(@Param("keys") String keys);

    //特殊物品缓存
    @MapKey("cacheKey")
    Map<String, SpecialCommodityCacheBo> addSpecialCommodityCache(@Param("keys") String keys);

    //附加费缓存
    @MapKey("cacheKey")
    Map<String, SurchargeCacheBo> addSurchargeCache(@Param("keys") String keys);

    //计泡方式缓存
    @MapKey("cacheKey")
    Map<String, WeightWayCacheBo> addWeightWayCache(@Param("keys") String keys);
}

