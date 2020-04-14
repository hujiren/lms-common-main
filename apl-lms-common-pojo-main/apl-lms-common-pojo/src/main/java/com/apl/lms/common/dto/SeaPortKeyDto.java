package com.apl.lms.common.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 海港 持久化对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sea_port")
@ApiModel(value="海港 持久化对象", description="海港 持久化对象")
public class SeaPortKeyDto extends Model<SeaPortKeyDto> {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(name = "portCode" , value = "代码" , required = true)
    @NotEmpty(message = "代码不能为空")
    private String portCode;

    @ApiModelProperty(name = "nameCn" , value = "中文名" , required = true)
    @NotEmpty(message = "中文名不能为空")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名" , required = true)
    @NotEmpty(message = "英文名不能为空")
    private String nameEn;

    @ApiModelProperty(name = "countryCode" , value = "国家简码" , required = true)
    @NotEmpty(message = "国家简码不能为空")
    private String countryCode;

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
