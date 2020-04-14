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
 * 国家 持久化对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("country")
@ApiModel(value="国家 持久化对象", description="国家 持久化对象")
public class CountryKeyDto extends Model<CountryKeyDto> {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(name = "countryCode" , value = "国家代码" , required = true)
    @NotEmpty(message = "国家代码不能为空")
    private String countryCode;

    @ApiModelProperty(name = "areaCode" , value = "地区代码" , required = true)
    @NotEmpty(message = "地区代码不能为空")
    private String areaCode;

    @ApiModelProperty(name = "nameCn" , value = "中文名" , required = true)
    @NotEmpty(message = "中文名不能为空")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名" , required = true)
    @NotEmpty(message = "英文名不能为空")
    private String nameEn;

    @ApiModelProperty(name = "startZip" , value = "起始邮编" , required = true)
    @NotEmpty(message = "起始邮编不能为空")
    private String startZip;

    @ApiModelProperty(name = "endZip" , value = "截止邮编" , required = true)
    @NotEmpty(message = "截止邮编不能为空")
    private String endZip;

    @ApiModelProperty(name = "type" , value = "分类：1国家  2地区" , required = true)
    private Boolean type;

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
