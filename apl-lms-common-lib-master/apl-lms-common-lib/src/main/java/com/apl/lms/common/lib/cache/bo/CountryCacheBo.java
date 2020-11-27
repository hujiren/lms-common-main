package com.apl.lms.common.lib.cache.bo;

import lombok.Data;

import java.io.Serializable;


/**
 * @author hjr start
 * @date 2020/4/17 - 17:40
 */
@Data
public class CountryCacheBo implements Serializable {

    private String cacheKey;

    private String countryCode;

    private String nameCn;

    private String nameEn;
}
