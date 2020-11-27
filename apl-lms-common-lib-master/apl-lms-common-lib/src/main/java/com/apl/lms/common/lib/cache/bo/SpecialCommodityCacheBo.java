package com.apl.lms.common.lib.cache.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hjr start
 * @Classname SpecialCommodityCacheBo
 * @Date 2020/8/31 16:54
 */
@Data
public class SpecialCommodityCacheBo implements Serializable {

   private String cacheKey;

   private Integer code;

   private String specialCommodityName;

   private String specialCommodityNameEn;

}
