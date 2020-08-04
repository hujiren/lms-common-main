package com.apl.lms.common.lib.cache;
import com.apl.db.abatis.MyBatisPlusConfig;
import com.apl.lib.cachebase.BaseCacheUtil;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.feign.LmsCommonFeign;

/**
 * @author hjr start
 * @date 2020/4/21 - 17:25
 */
public class JoinAirCarrier extends JoinBase<AirCarrierCacheBo> {

    private Long customerId;

    private LmsCommonFeign lmsCommonFeign;


    public JoinAirCarrier(int joinStyle, LmsCommonFeign lmsCommonFeign, BaseCacheUtil cacheUtil){
        this.lmsCommonFeign = lmsCommonFeign;
        this.cacheUtil = cacheUtil;
        this.joinStyle = joinStyle;
        this.tabName = "air_carrier";
        this.innerOrgId = MyBatisPlusConfig.tenantIdContextHolder.get();
        this.cacheKeyNamePrefix = "JOIN_CACHE:" + this.tabName + "_" + this.innerOrgId.toString() + "_";
    }

    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey) {
        ResultUtil<Boolean> ResultUtil = lmsCommonFeign.addAirCarrierCacheById(keys, minKey, maxKey);
        if(ResultUtil.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.code)){
            return true;
        }


        return false;
    }
}
