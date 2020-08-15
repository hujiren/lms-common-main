package com.apl.lms.common.query.manage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * @author hjr start
 * @date 2020/8/8 - 9:17
 */
@Data
@ApiModel(value = "附加费插入对象", description = "附加费插入对象")
public class SurchargeInsertDto {

    @ApiModelProperty(name = "chargeName", value = "附加费名称", required = true)
    @NotBlank(message = "附加费名称名称不能为空")
    private String chargeName;

    @ApiModelProperty(name = "computingFormula", value = "计算公式", required = true)
    @NotBlank(message = "计算公式不能为空")
    private String computingFormula;

    @ApiModelProperty(name = "currency", value = "币制", required = true)
    @NotBlank(message = "币制不能为空")
    private String currency;
}