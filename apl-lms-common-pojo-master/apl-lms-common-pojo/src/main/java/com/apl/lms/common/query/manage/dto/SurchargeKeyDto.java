package com.apl.lms.common.query.manage.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 附加费
 * @author hjr start
 * @date 2020/8/8 - 9:17
 */
@Data
@ApiModel(value = "附加费 查询对象", description = "附加费 查询对象")
public class SurchargeKeyDto {

    @ApiModelProperty(name = "keyword", value = "关键字")
    private String keyword;

    @ApiModelProperty(name = "code", value = "code")
    private Integer code;

    public String getKeyword() {
        if (keyword != null && keyword.trim().equals(""))
            keyword = null;

        return keyword;
    }

}
