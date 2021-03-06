package com.apl.lms.common.lib.cache;
import com.apl.lib.cachebase.BaseCacheUtil;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.cache.bo.SeaPortCacheBo;
import com.apl.lms.common.lib.feign.LmsCommonFeign;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:41
 */
public class JoinSeaPort extends JoinBase<SeaPortCacheBo> {

    private LmsCommonFeign lmsCommonFeign;


    public JoinSeaPort(int joinStyle, LmsCommonFeign lmsCommonFeign, BaseCacheUtil cacheUtil) {
        this.lmsCommonFeign = lmsCommonFeign;
        this.cacheUtil = cacheUtil;
        this.tabName = "common_sea_port";
        this.joinStyle = joinStyle;
        this.cacheKeyNamePrefix = "JOIN_CACHE:common_sea_port:";
    }


    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey){

        ResultUtil<Boolean> result = lmsCommonFeign.addSeaPortCacheById(keys);

        if(result.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.code))
            return true;

        return false;
    }
}
