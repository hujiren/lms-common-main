package com.apl.lms.common.lib.cache;

import com.apl.lib.cachebase.BaseCacheUtil;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.cache.bo.SeaCarrierCacheBo;
import com.apl.lms.common.lib.feign.LmsCommonFeign;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:41
 */
public class JoinSeaCarrier extends JoinBase<SeaCarrierCacheBo> {

    private LmsCommonFeign lmsCommonFeign;


    public JoinSeaCarrier(int joinStyle, LmsCommonFeign lmsCommonFeign, BaseCacheUtil cacheUtil) {
        this.lmsCommonFeign = lmsCommonFeign;
        this.cacheUtil = cacheUtil;
        this.tabName = "common_sea_carrier";
        this.joinStyle = joinStyle;
        this.cacheKeyNamePrefix = "JOIN_CACHE:common_sea_carrier:";
    }


    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey){

        ResultUtil<Boolean> result = lmsCommonFeign.addSeaCarrierCacheById(keys);

        if(result.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.code))
            return true;

        return false;
    }
}
