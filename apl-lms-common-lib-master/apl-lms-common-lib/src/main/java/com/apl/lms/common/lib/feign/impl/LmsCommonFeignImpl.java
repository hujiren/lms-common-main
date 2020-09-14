package com.apl.lms.common.lib.feign.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.feign.LmsCommonFeign;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:34
 */
public class LmsCommonFeignImpl implements LmsCommonFeign {

    @Override
    public ResultUtil<Boolean> addCountryCacheByCode(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }


    @Override
    public ResultUtil<Boolean> addAirCarrierCacheById(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }


    @Override
    public ResultUtil<Boolean> addAirPortCacheByCode(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode(), CommonStatusCode.SERVER_INVOKE_FAIL.getMsg(), null);
    }


    @Override
    public ResultUtil<Boolean> addSeaPortCacheById(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }


    @Override
    public ResultUtil<Boolean> addSeaCarrierCacheById(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }

    @Override
    public ResultUtil<Boolean> addCommodityUnitCacheById(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }

    @Override
    public ResultUtil<Boolean> addSpecialCommodityCache(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }

    @Override
    public ResultUtil<Boolean> addSurchargeCache(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }

    @Override
    public ResultUtil<Boolean> addWeightWayCache(@RequestParam("keys") String keys) {
        return ResultUtil.APPRESULT(CommonStatusCode.SERVER_INVOKE_FAIL.getCode() , CommonStatusCode.SERVER_INVOKE_FAIL.getMsg() , null);
    }
}
