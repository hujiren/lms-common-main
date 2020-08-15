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
@TableName("special_commodity")
@ApiModel(value = "特殊物品持久化对象", description = "特殊物品持久化对象")
public class SpecialCommodityDto {

    @ApiModelProperty(name = "id", value = "特殊物品id", required = true)
    @TableId(value = "id", type = IdType.INPUT)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "特殊物品Id不能为空")
    private Long id;

    @ApiModelProperty(name = "specialCommodityName", value = "特殊物品名称", required = true)
    @NotBlank(message = "特殊物品名称不能为空")
    private String specialCommodityName;
}