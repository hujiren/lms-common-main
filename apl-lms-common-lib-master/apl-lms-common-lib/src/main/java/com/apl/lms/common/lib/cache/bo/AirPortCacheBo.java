package com.apl.lms.common.lib.cache.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/4/22 - 9:25
 */
@Data
public class AirPortCacheBo implements Serializable {

    private String cacheKey;

    private String portCode;

    private String nameCn;

    private String nameEn;

    private String homeCountry;
}
