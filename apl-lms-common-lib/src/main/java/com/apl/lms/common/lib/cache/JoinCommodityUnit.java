package com.apl.lms.common.lib.cache;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.datasource.DataSourceContextHolder;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.lib.feign.LmsCommonFeign;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:41
 */
public class JoinCommodityUnit extends JoinBase<CommodityUnitCacheBo> {

    private LmsCommonFeign lmsCommonFeign;

    private Long customerId;


    public JoinCommodityUnit(int joinStyle, LmsCommonFeign lmsCommonFeign, RedisTemplate redisTemplate) {
        this.lmsCommonFeign = lmsCommonFeign;
        this.redisTemplate = redisTemplate;
        this.tabName = "commodity_unit";
        this.joinStyle = joinStyle;
        this.innerOrgId = DataSourceContextHolder.getInnerOrgId();
        this.cacheKeyNamePrefix = "JOIN_CACHE:" + this.tabName + "_" + this.innerOrgId.toString() + "_";
    }


    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey){

        ResultUtils<Boolean> result = lmsCommonFeign.addCommodityUnitCacheById(keys, minKey, maxKey);
        if(result.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.code))
            return true;

        return false;
    }
}