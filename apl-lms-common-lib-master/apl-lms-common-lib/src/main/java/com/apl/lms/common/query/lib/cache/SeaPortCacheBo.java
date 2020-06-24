package com.apl.lms.common.query.lib.cache;

import lombok.Data;

/**
 * @author hjr start
 * @date 2020/4/22 - 11:39
 */
@Data
public class SeaPortCacheBo {

    private String cacheKey;

    private String portCode;

    private String nameCn;

    private String nameEn;

    private String homeCountry;
}
