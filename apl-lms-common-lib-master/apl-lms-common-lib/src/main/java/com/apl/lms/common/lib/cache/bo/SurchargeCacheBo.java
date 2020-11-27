package com.apl.lms.common.lib.cache.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @Classname SurchargeCacheBo
 * @Date 2020/9/2 10:05
 */
@Data
public class SurchargeCacheBo implements Serializable {

    private String cacheKey;

    private Integer code;

    private String computingFormula;

    private String currency;

    private String charge_name;
}
