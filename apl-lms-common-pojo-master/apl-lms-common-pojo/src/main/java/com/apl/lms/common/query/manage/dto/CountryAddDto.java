package com.apl.lms.common.query.manage.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@TableName("common_country")
@ApiModel(value="国家 交互对象", description="国家 交互对象")
public class CountryAddDto extends Model<CountryAddDto> {

    @ApiModelProperty(name = "countryCode" , value = "简码" , required = true)
    @NotEmpty(message = "简码不能为空")
    @Length(max=3, message = "简码长度不能超过3")
    private String countryCode;

    @ApiModelProperty(name = "nameCn" , value = "中文名" , required = true)
    @NotEmpty(message = "中文名不能为空")
    @Length(max=100, message = "中文名长度不能超过100")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名", required = true)
    @NotEmpty(message = "英文名不能为空")
    @Length(max = 100, message = "英文名不能超过100")
    private String nameEn;

    @ApiModelProperty(name = "startZip" , value = "起始邮编")
    @Length(max=10, message = "起始邮编长度不能超过10")
    private String startZip;

    @ApiModelProperty(name = "endZip" , value = "截止邮编")
    @Length(max=10, message = "截止邮编长度不能超过10")
    private String endZip;

    @ApiModelProperty(name = "type" , value = "类型：1国家  2地区", required = true)
    @NotNull(message = "类型不能为空")
    @Range(min = 1, max=2, message = "类型必须是1或2")
    private Integer type;

    @ApiModelProperty(name = "aliasName" , value = "别名")
    @Length(max=200, message = "别名长度不能超过200")
    private String  aliasName;

    @ApiModelProperty(name = "homeCountry" , value = "所属国家")
    @Length(max=3, message = "所属国家(简码)长度不能超过3")
    private String  homeCountry;

    private static final long serialVersionUID=1L;

}
