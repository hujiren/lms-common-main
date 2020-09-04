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
@ApiModel(value = "计泡方式插入对象", description = "计泡方式插入对象")
public class WeightWayAddDto {

    @ApiModelProperty(name = "weightWayName", value = "计泡方式名称", required = true)
    @NotBlank(message = "计泡方式名称不能为空")
    private String weightWayName;

    @ApiModelProperty(name = "weightWayNameEn", value = "计泡方式英文名称", required = true)
    @NotBlank(message = "计泡方式英文名称不能为空")
    private String weightWayNameEn;

    @ApiModelProperty(name = "computingFormula", value = "计算公式", required = true)
    @NotBlank(message = "计算公式不能为空")
    private String computingFormula;

    @ApiModelProperty(name = "code", value = "计泡方式代码", required = true)
    @NotNull(message = "计泡方式代码")
    private Integer code;
}
