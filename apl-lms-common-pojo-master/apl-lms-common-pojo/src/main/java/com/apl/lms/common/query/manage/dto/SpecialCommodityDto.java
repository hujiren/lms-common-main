package com.apl.lms.common.query.manage.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 特殊物品
 * @author hjr start
 * @date 2020/8/8 - 9:17
 */
@Data
@TableName("common_special_commodity")
@ApiModel(value = "特殊物品 交互对象", description = "特殊物品 交互对象")
public class SpecialCommodityDto {

    @ApiModelProperty(name = "id", value = "特殊物品id", required = true)
    @TableId(value = "id", type = IdType.INPUT)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "特殊物品Id不能为空")
    private Long id;

    @ApiModelProperty(name = "specialCommodityName", value = "特殊物品名称", required = true)
    @NotBlank(message = "特殊物品名称不能为空")
    private String specialCommodityName;

    @ApiModelProperty(name = "specialCommodityNameEn", value = "特殊物品英文名称", required = true)
    @NotBlank(message = "特殊物品英文名称不能为空")
    private String specialCommodityNameEn;

    @ApiModelProperty(name = "code", value = "特殊物品代码", required = true)
    @NotNull(message = "特殊物品代码")
    private Integer code;
}