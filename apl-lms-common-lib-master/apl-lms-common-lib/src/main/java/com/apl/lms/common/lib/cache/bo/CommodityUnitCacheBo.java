package com.apl.lms.common.lib.cache.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/4/22 - 15:22
 */
@Data
public class CommodityUnitCacheBo implements Serializable {

    private String cacheKey;

    private String unitCode;

    private String unitName;
}
