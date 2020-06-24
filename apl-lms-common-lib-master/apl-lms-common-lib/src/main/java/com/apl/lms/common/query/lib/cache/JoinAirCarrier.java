package com.apl.lms.common.query.lib.cache;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.datasource.DataSourceContextHolder;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.query.lib.feign.LmsCommonFeign;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author hjr start
 * @date 2020/4/21 - 17:25
 */
public class JoinAirCarrier extends JoinBase<AirCarrierCacheBo> {

    private Long customerId;

    private LmsCommonFeign lmsCommonFeign;

    public JoinAirCarrier(int joinStyle, LmsCommonFeign lmsCommonFeign, RedisTemplate redisTemplate){
        this.lmsCommonFeign = lmsCommonFeign;
        this.redisTemplate = redisTemplate;
        this.joinStyle = joinStyle;
        this.tabName = "air_carrier";
        this.innerOrgId = DataSourceContextHolder.getInnerOrgId();
        this.cacheKeyNamePrefix = "JOIN_CACHE:" + this.tabName + "_" + this.innerOrgId.toString() + "_";
    }

    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey) {
        ResultUtils<Boolean> resultUtils = lmsCommonFeign.addAirCarrierCacheById(keys, minKey, maxKey);
        if(resultUtils.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.code)){
            return true;
        }
        return false;
    }
}
