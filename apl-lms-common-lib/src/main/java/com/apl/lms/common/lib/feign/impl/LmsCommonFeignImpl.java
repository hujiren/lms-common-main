package com.apl.lms.common.lib.feign.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.lib.feign.LmsCommonFeign;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:34
 */
public class LmsCommonFeignImpl implements LmsCommonFeign {

    @Override
    public ResultUtils<Boolean> addCountryCacheByCode(@RequestParam("keys") String keys,
                                                      @RequestParam("minKey") Long minKey,
                                                      @RequestParam("maxKey") Long maxKey) {
        return ResultUtils.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }


    @Override
    public ResultUtils<Boolean> addAirCarrierCacheById(@RequestParam("keys") String keys,
                                                       @RequestParam("minKey") Long minKey,
                                                       @RequestParam("maxKey") Long maxKey) {
        return ResultUtils.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }


    @Override
    public ResultUtils<Boolean> addAirPortCacheByCode(@RequestParam("keys") String keys,
                                                      @RequestParam("minKey") Long minKey,
                                                      @RequestParam("maxKey") Long maxKey) {
        return ResultUtils.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode(), CommonStatusCode.SERVER_INVOKE_FAIL.getMsg(), null);
    }


    @Override
    public ResultUtils<Boolean> addSeaPortCacheById(@RequestParam("keys") String keys,
                                                      @RequestParam("minKey") Long minKey,
                                                      @RequestParam("maxKey") Long maxKey) {
        return ResultUtils.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }


    @Override
    public ResultUtils<Boolean> addSeaCarrierCacheById(@RequestParam("keys") String keys,
                                                       @RequestParam("minKey") Long minKey,
                                                       @RequestParam("maxKey") Long maxKey) {
        return ResultUtils.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }

    @Override
    public ResultUtils<Boolean> addCommodityUnitCacheById(@RequestParam("keys") String keys,
                                                          @RequestParam("minKey") Long minKey,
                                                          @RequestParam("maxKey") Long maxKey) {
        return ResultUtils.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }
}
