package com.apl.lms.common.query.manage.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hjr start
 * @date 2020/8/8 - 9:17
 */
@Data
@ApiModel(value = "特殊物品查询对象", description = "特殊物品查询对象")
public class SpecialCommodityKeyDto {

    @ApiModelProperty(name = "keyword", value = "关键字")
    private String keyword;

    public String getKeyword() {
        if (keyword != null && keyword.trim().equals(""))
            keyword = null;

        return keyword;
    }
}