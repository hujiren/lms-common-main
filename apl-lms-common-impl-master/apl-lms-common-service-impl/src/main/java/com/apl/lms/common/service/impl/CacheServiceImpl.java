package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.security.SecurityUser;
import com.apl.lib.utils.CommonContextHolder;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.cache.*;
import com.apl.lms.common.mapper.CacheMapper;
import com.apl.lms.common.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
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

    //状态code枚举
    enum CacheServiceServiceCode {
        SKU_AND_CUSTOMERID_IS_NULL("SKUS_AND_CUSTOMERID_IS_NULL" ,"SKU和CUSTOMERID不能同时为空"),
        ;
        private String code;
        private String msg;

        CacheServiceServiceCode(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    CacheMapper cacheMapper;


    //添加仓库缓存
    @Override
    public ResultUtil<Boolean> addCountryCache(String codes){
        codes = codes.toUpperCase();
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();
        Map<String, CountryCacheBo> maps = cacheMapper.addCountryCache(codes, securityUser.getInnerOrgId());
        if(null != maps && maps.size()>0) {
            redisTemplate.opsForValue().multiSet(maps);
            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, false);
    }

    @Override
    public ResultUtil<Boolean> addAirCarrierCache(String keys, Long minKey, Long maxKey) {
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();
        Map<String , AirCarrierCacheBo> maps = cacheMapper.addAirCarrierCache(keys, minKey, maxKey, securityUser.getInnerOrgId());
        if(null != maps && maps.size() > 0){
            redisTemplate.opsForValue().multiSet(maps);
            return ResultUtil.APPRESULT(CommonStatusCode.GET_FAIL.SYSTEM_SUCCESS, true);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.GET_FAIL.SYSTEM_FAIL, false);
    }

    @Override
    public ResultUtil<Boolean> addAirPortCache(String codes) {
        codes = codes.toUpperCase();
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();
        Map<String, AirPortCacheBo> maps = cacheMapper.addAirPortCache(codes, securityUser.getInnerOrgId());
        if(null != maps && maps.size() > 0){
            redisTemplate.opsForValue().multiSet(maps);
            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_FAIL, false);
    }


    @Override
    public ResultUtil<Boolean> addSeaPortCache(String keys, Long minKey, Long maxKey) {
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();
        Map<String, SeaPortCacheBo> maps = cacheMapper.addSeaPortCache(keys, securityUser.getInnerOrgId(), minKey, maxKey);
        if(null != maps && maps.size() > 0){
            redisTemplate.opsForValue().multiSet(maps);
            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_FAIL, false);
    }


    @Override
    public ResultUtil<Boolean> addSeaCarrierCache(String keys, Long maxKey, Long minKey) {
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();
        Map<String, SeaCarrierCacheBo> maps = cacheMapper.addSeaCarrierCache(keys, securityUser.getInnerOrgId(), minKey, maxKey);
        if(null != maps && maps.size() > 0){
            redisTemplate.opsForValue().multiSet(maps);
            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_FAIL, false);
    }


    @Override
    public ResultUtil<Boolean> addCommodityUnitCache(String keys, Long maxKey, Long minKey) {
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();
        Map<String, CommodityUnitCacheBo> maps = cacheMapper.addCommodityUnitCache(keys, securityUser.getInnerOrgId(), minKey, maxKey);
        if(null != maps && maps.size() > 0){
            redisTemplate.opsForValue().multiSet(maps);
            return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_SUCCESS, true);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SYSTEM_FAIL, false);
    }
}