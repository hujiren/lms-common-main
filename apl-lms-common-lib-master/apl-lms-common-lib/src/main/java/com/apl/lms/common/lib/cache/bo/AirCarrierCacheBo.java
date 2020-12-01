package com.apl.lms.common.lib.cache.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/4/20 - 11:22
 */
@Data
public class AirCarrierCacheBo implements Serializable {

    private String cacheKey;

    private String carrierCode;

    private String nameCn;

    private String nameEn;

}
