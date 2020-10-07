package com.apl.lms.common.query.manage.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * <p>
 *  持久化对象
 * </p>
 *
 * @author hjr
 * @since 2020-09-29
 */
@Data
@TableName("common_freight_type")
@ApiModel(value=" 运输类型-持久化对象", description=" 运输类型-持久化对象")
public class CommonFreightTypePo extends Model<CommonFreightTypePo> {

    @NotNull(message = "运输类型id不能为空")
    @ApiModelProperty(name = "id", value = "id", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id", type = IdType.INPUT)
    @Min(value = 0, message = "运输类型id不能小于0")
    private Long id;

    @ApiModelProperty(name = "code" , value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Integer code;

    @ApiModelProperty(name = "freightTypeName" , value = "运输类型名称" , required = true)
    @NotBlank(message = "运输类型名称不能为空")
    @Length(max = 50, message = "运输类型名称长度不能超过50")
    private String freightTypeName;

    @ApiModelProperty(name = "autoAdd" , value = "是否自动添加 1是 2否" , required = true)
    @NotNull(message = "<是否自动添加>该属性不能为空")
    @Range(min = 1, max = 2, message = "是否自动添加的值只能为1或2")
    private Integer autoAdd;

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
