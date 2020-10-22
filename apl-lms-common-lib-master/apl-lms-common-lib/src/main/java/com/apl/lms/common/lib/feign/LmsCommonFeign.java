package com.apl.lms.common.lib.feign;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.feign.impl.LmsCommonFeignImpl;
import com.apl.lms.common.query.manage.po.CommonCarrierPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:33
 */
@Component
@FeignClient(name = "apl-lms-common-manage-app" , path = "lms-common-manage", fallback = LmsCommonFeignImpl.class)
public interface LmsCommonFeign {

    @PostMapping("/cache/add-country-cache")
    ResultUtil<Boolean> addCountryCacheByCode(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-air-carrier-cache")
    ResultUtil<Boolean> addAirCarrierCacheById(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-air-port-code")
    ResultUtil<Boolean> addAirPortCacheByCode(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-sea-port-code")
    ResultUtil<Boolean> addSeaPortCacheById(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-sea-carrier-code")
    ResultUtil<Boolean> addSeaCarrierCacheById(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-commodity-unit-code")
    ResultUtil<Boolean> addCommodityUnitCacheById(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-special-commodity-cache")
    ResultUtil<Boolean> addSpecialCommodityCache(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-surcharge-cache")
    ResultUtil<Boolean> addSurchargeCache(@RequestParam("keys") String keys);

    @PostMapping("/cache/add-weight-way-cache")
    ResultUtil<Boolean> addWeightWayCache(@RequestParam("keys") String keys);

    @PostMapping("/common-carrier/get-list")
    ResultUtil<List<CommonCarrierPo>> getList();
}

