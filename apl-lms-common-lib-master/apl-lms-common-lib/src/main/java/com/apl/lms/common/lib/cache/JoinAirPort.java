package com.apl.lms.common.lib.cache;

import com.apl.lib.cachebase.BaseCacheUtil;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.feign.LmsCommonFeign;
import com.apl.tenant.AplTenantConfig;

/**
 * @author hjr start
 * @date 2020/4/22 - 9:52
 */
public class JoinAirPort extends JoinBase<AirPortCacheBo> {

    private LmsCommonFeign lmsCommonFeign;
    private Long customerId;

    public JoinAirPort(int joinStyle, LmsCommonFeign lmsCommonFeign, BaseCacheUtil cacheUtil){
        this.lmsCommonFeign = lmsCommonFeign;
        this.cacheUtil = cacheUtil;
        this.tabName = "air_port";
        this.joinStyle = joinStyle;
        this.innerOrgId = AplTenantConfig.tenantIdContextHolder.get();
        this.cacheKeyNamePrefix = "JOIN_CACHE:" + this.tabName + "_" + this.innerOrgId.toString() + "_";
    }

    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey) {
        ResultUtil<Boolean> result = lmsCommonFeign.addAirPortCacheByCode(keys, minKey, maxKey);
        if(result.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.getCode())){
            return true;
        }
        return false;
    }
}
