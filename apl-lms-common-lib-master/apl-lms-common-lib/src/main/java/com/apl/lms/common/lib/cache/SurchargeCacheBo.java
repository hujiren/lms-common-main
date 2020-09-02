package com.apl.lms.common.lib.cache;

import lombok.Data;

/**
 * @author hjr start
 * @Classname SurchargeCacheBo
 * @Date 2020/9/2 10:05
 */
@Data
public class SurchargeCacheBo {

    private String cacheKey;

    private Long id;

    private String computingFormula;

    private String currency;

    private String charge_name;
}
