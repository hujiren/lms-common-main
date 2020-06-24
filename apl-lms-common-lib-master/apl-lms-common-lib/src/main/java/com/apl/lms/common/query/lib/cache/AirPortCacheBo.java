package com.apl.lms.common.query.lib.cache;

import lombok.Data;

/**
 * @author hjr start
 * @date 2020/4/22 - 9:25
 */
@Data
public class AirPortCacheBo {

    private String cacheKey;

    private String portCode;

    private String nameCn;

    private String nameEn;

    private String homeCountry;
}