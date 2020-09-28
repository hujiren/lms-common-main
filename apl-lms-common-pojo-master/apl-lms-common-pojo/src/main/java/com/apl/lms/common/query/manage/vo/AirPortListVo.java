package com.apl.lms.common.query.manage.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 机场 持久化对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("common_air_port")
@ApiModel(value="AirPortAddDto 持久化对象", description="机场")
public class AirPortListVo extends Model<AirPortListVo> {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "portCode" , value = "机场简码")
    @NotEmpty(message = "机场简码不能为空")
    @Length(max = 3, message = "机场简码长度不能超过3")
    private String portCode;

    @ApiModelProperty(name = "nameCn" , value = "中文名")
    @NotEmpty(message = "中文名不能为空")
    @Length(max = 100, message = "中文名长度不能超过100")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名")
    @NotEmpty(message = "英文名不能为空")
    @Length(max = 100, message = "英文名长度不能超过100")
    private String nameEn;

    @ApiModelProperty(name = "homeCountry" , value = "所属国家")
    @NotEmpty(message = "所属国家不能为空")
    @Length(max = 3, message = "所属国家长度不能超过3")
    private String homeCountry;

    @ApiModelProperty(name = "aliasName" , value = "别名")
    @Length(max = 200, message = "别名长度不能超过200")
    private String  aliasName;

    @ApiModelProperty(name = "countryNameCn" , value = "国家中文名")
    @NotEmpty(message = "国家中文名不能为空")
    @Length(max = 100, message = "国家中文名长度不能超过100")
    private String  countryNameCn;

    @ApiModelProperty(name = "countryNameEn" , value = "国家英文名")
    @Length(max = 100, message = "国家英文名长度不能超过100")
    private String  countryNameEn;

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
