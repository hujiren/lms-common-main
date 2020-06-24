package com.apl.lms.common.query.lib.cache;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author hjr start
 * @date 2020/4/20 - 11:22
 */
@Data
public class AirCarrierCacheBo {

    private String cacheKey;

    private String carrierCode;

    private String nameCn;

    private String nameEn;

}