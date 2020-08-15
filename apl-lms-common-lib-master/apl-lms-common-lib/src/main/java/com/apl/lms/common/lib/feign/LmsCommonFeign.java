package com.apl.lms.common.lib.feign;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.lib.feign.impl.LmsCommonFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hjr start
 * @date 2020/4/17 - 17:33
 */
@Component
@FeignClient(value = "apl-lms-common-manage-app" , fallback = LmsCommonFeignImpl.class)
public interface LmsCommonFeign {

    @PostMapping("/cache/add-country-cache")
    ResultUtil<Boolean> addCountryCacheByCode(@RequestParam("keys") String keys,
                                               @RequestParam("minKey") Long minKey,
                                               @RequestParam("maxKey") Long maxKey);


    @PostMapping("/cache/add-air-carrier-cache")
    ResultUtil<Boolean> addAirCarrierCacheById(@RequestParam("keys") String keys,
                                                @RequestParam("minKey") Long minKey,
                                                @RequestParam("maxKey") Long maxKey);


    @PostMapping("/cache/add-air-port-code")
    ResultUtil<Boolean> addAirPortCacheByCode(@RequestParam("keys") String keys,
                                               @RequestParam("minKey") Long minKey,
                                               @RequestParam("maxKey") Long maxKey);


    @PostMapping("/cache/add-sea-port-code")
    ResultUtil<Boolean> addSeaPortCacheById(@RequestParam("keys") String keys,
                                               @RequestParam("minKey") Long minKey,
                                               @RequestParam("maxKey") Long maxKey);

    @PostMapping("/cache/add-sea-carrier-code")
    ResultUtil<Boolean> addSeaCarrierCacheById(@RequestParam("keys") String keys,
                                               @RequestParam("minKey") Long minKey,
                                               @RequestParam("maxKey") Long maxKey);

    @PostMapping("/cache/add-commodity-unit-code")
    ResultUtil<Boolean> addCommodityUnitCacheById(@RequestParam("keys") String keys,
                                               @RequestParam("minKey") Long minKey,
                                               @RequestParam("maxKey") Long maxKey);
}
