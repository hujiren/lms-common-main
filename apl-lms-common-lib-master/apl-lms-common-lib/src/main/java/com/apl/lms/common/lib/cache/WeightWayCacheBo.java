package com.apl.lms.common.lib.cache;

import lombok.Data;

/**
 * @author hjr start
 * @Classname SurchargeCacheBo
 * @Date 2020/9/2 10:05
 */
@Data
public class WeightWayCacheBo {

    private String cacheKey;

    private Long id;

    private String weightWayName;

    private String computingFormula;

}
