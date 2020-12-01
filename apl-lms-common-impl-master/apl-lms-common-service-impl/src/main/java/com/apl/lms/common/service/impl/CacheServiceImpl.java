package com.apl.lms.common.service.impl;

import com.apl.cache.AplCacheUtil;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.cache.bo.*;
import com.apl.lms.common.mapper.CacheMapper;
import com.apl.lms.common.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @Description : 跨库缓存客户缓存
 * @Param ： * @param null
 * @Return ：
 * @Author : arran
 * @Date :
 */

@Service
@Slf4j
public class CacheServiceImpl implements CacheService {

    @Autowired
    AplCacheUtil aplCacheUtil;

    @Autowired
    CacheMapper cacheMapper;

    enum CacheServiceEnum{

        CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND("CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND", "缓存失败,没有找打对应的数据");

        private String code;
        private String msg;

        CacheServiceEnum(String code, String msg){
            this.code = code;
            this.msg = msg;
        }
    }

    /**
     * 国家缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addCountryCache(String keys) throws IOException {

        keys = keys.toUpperCase();
        Map<String, CountryCacheBo> maps = cacheMapper.addCountryCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 航空公司缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addAirCarrierCache(String keys) throws IOException {

        Map<String, AirCarrierCacheBo> maps = cacheMapper.addAirCarrierCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.GET_FAIL.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 机场缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addAirPortCache(String keys) throws IOException {

        keys = keys.toUpperCase();
        Map<String, AirPortCacheBo> maps = cacheMapper.addAirPortCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 海港缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addSeaPortCache(String keys) throws IOException {

        Map<String, SeaPortCacheBo> maps = cacheMapper.addSeaPortCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 船公司缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addSeaCarrierCache(String keys) throws IOException {

        Map<String, SeaCarrierCacheBo> maps = cacheMapper.addSeaCarrierCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 单位管理缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addCommodityUnitCache(String keys) throws IOException {

        Map<String, CommodityUnitCacheBo> maps = cacheMapper.addCommodityUnitCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 特殊物品缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addSpecialCommodityCache(String keys) throws IOException {

        Map<String, SpecialCommodityCacheBo> maps = cacheMapper.addSpecialCommodityCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 附加费缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addSurchargeCache(String keys) throws IOException {

        Map<String, SurchargeCacheBo> maps = cacheMapper.addSurchargeCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }

    /**
     * 计泡方式缓存
     * @param keys
     * @return
     * @throws IOException
     */
    @Override
    public ResultUtil<Boolean> addWeightWayCache(String keys) throws IOException {

        Map<String, WeightWayCacheBo> maps = cacheMapper.addWeightWayCache(keys);
        if (null != maps && maps.size() > 0) {
            aplCacheUtil.opsForValue().set(maps);

            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.code,
                CacheServiceEnum.CACHING_FAILURE_NO_CORRESPONDING_DATA_WAS_FOUND.msg,false);

    }
}