package com.apl.lms.common.lib.cache;

import com.apl.db.abatis.MyBatisPlusConfig;
import com.apl.lib.cachebase.BaseCacheUtil;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.feign.LmsCommonFeign;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:41
 */
public class JoinSeaCarrier extends JoinBase<SeaCarrierCacheBo> {

    private LmsCommonFeign lmsCommonFeign;

    private Long customerId;


    public JoinSeaCarrier(int joinStyle, LmsCommonFeign lmsCommonFeign, BaseCacheUtil cacheUtil) {
        this.lmsCommonFeign = lmsCommonFeign;
        this.cacheUtil = cacheUtil;
        this.tabName = "sea_carrier";
        this.joinStyle = joinStyle;
        this.innerOrgId = MyBatisPlusConfig.tenantIdContextHolder.get();
        this.cacheKeyNamePrefix = "JOIN_CACHE:" + this.tabName + "_" + this.innerOrgId.toString() + "_";
    }


    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey){

        ResultUtil<Boolean> result = lmsCommonFeign.addSeaCarrierCacheById(keys, minKey, maxKey);
        if(result.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.code))
            return true;

        return false;
    }
}
