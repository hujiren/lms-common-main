package com.apl.lms.common.lib.cache;

import lombok.Data;

/**
 * @author hjr start
 * @date 2020/4/22 - 11:39
 */
@Data
public class SeaCarrierCacheBo {

    private String cacheKey;

    private String carrierCode;

    private String nameCn;

    private String nameEn;
}
