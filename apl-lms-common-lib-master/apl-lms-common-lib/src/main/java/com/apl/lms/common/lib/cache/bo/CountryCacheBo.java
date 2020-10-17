package com.apl.lms.common.lib.cache.bo;

import lombok.Data;


/**
 * @author hjr start
 * @date 2020/4/17 - 17:40
 */
@Data
public class CountryCacheBo {

    private String cacheKey;

    private String countryCode;

    private String nameCn;

    private String nameEn;
}
