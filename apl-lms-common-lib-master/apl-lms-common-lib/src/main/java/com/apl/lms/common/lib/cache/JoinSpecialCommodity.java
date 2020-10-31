package com.apl.lms.common.lib.cache;
import com.apl.lib.cachebase.BaseCacheUtil;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.join.JoinBase;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.cache.bo.SpecialCommodityCacheBo;
import com.apl.lms.common.lib.feign.LmsCommonFeign;
import com.apl.tenant.AplTenantConfig;

/**
 * @author hjr start
 * @Classname JoinSpecialCommodity
 * @Date 2020/9/2 9:57
 */
public class JoinSpecialCommodity extends JoinBase<SpecialCommodityCacheBo> {

    private LmsCommonFeign lmsCommonFeign;

    public JoinSpecialCommodity(int joinStyle, LmsCommonFeign lmsCommonFeign, BaseCacheUtil cacheUtil) {
        this.lmsCommonFeign = lmsCommonFeign;
        this.cacheUtil = cacheUtil;
        this.tabName = "common_special_commodity";
        this.joinStyle = joinStyle;
        this.cacheKeyNamePrefix = "JOIN_CACHE:common_special_commodity:";
    }

    @Override
    public Boolean addCache(String keys, Long minKey, Long maxKey){

        ResultUtil<Boolean> result = lmsCommonFeign.addSpecialCommodityCache(keys);
        if(result.getCode().equals(CommonStatusCode.SYSTEM_SUCCESS.code))
            return true;

        return false;
    }
}
