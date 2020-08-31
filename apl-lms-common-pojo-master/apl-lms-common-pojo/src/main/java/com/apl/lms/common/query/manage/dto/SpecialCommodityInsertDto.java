package com.apl.lms.common.query.manage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hjr start
 * @date 2020/8/8 - 9:17
 */
@Data
@ApiModel(value = "特殊物品插入对象", description = "特殊物品插入对象")
public class SpecialCommodityInsertDto {

    @ApiModelProperty(name = "specialCommodityName", value = "特殊物品名称", required = true)
    @NotBlank(message = "特殊物品名称不能为空")
    private String specialCommodityName;

    @ApiModelProperty(name = "code", value = "特殊物品代码", required = true)
    @NotNull(message = "特殊物品代码")
    private Integer code;
}
