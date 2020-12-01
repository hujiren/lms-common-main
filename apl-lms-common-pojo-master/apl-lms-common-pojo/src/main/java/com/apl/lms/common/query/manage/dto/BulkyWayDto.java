package com.apl.lms.common.query.manage.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hjr start
 * @date 2020/8/8 - 9:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("common_bulky_way")
@ApiModel(value = "计泡方式 交互对象", description = "计泡方式 交互对象")
public class BulkyWayDto {

    @ApiModelProperty(name = "id", value = "计泡方式Id", required = true)
    @TableId(value = "id", type = IdType.INPUT)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "计泡方式Id不能为空")
    private Long id;

    @ApiModelProperty(name = "bulkyWayName", value = "计泡方式名称", required = true)
    @NotBlank(message = "计泡方式名称不能为空")
    private String bulkyWayName;

    @ApiModelProperty(name = "bulkyWayNameEn", value = "计泡方式英文名称", required = true)
    @NotBlank(message = "计泡方式英文名称不能为空")
    private String bulkyWayNameEn;

    @ApiModelProperty(name = "computingFormula", value = "计算公式", required = true)
    @NotBlank(message = "计算公式不能为空")
    private String computingFormula;

    @ApiModelProperty(name = "code", value = "计泡方式代码", required = true)
    @NotNull(message = "计泡方式代码不能为空")
    private Integer code;
}
