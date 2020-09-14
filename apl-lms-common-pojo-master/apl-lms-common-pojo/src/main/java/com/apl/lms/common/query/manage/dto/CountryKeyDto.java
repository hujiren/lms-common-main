package com.apl.lms.common.query.manage.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 国家 分页对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("country")
@ApiModel(value="CountryKeyDto 分页对象", description="国家")
public class CountryKeyDto extends Model<CountryKeyDto> {

    @ApiModelProperty(name = "keyword", value = "关键词")
    @Length(max = 100, message = "关键词长度不能超过100")
    private String keyword;

    @ApiModelProperty(name = "upperKeyword", value = "大写关键词", hidden = true)
    private String upperKeyword;

    @ApiModelProperty(name = "type", value = "地区类型")
    @NotEmpty(message = "地区类型不能为空")
    private int type;

    @ApiModelProperty(name = "homeCountry", value = "所属国家")
    @Length(max = 3, message = "所属国家长度不能超过3")
    private String homeCountry;

    public String getUpperKeyword() {
        if (keyword == null || StringUtils.isEmpty(keyword.trim())){
            return  null;
        }

        return keyword.toUpperCase().trim();
    }
    
    public String getKeyword() {
        if (keyword == null || StringUtils.isEmpty(keyword.trim())){
            return  null;
        }


        return keyword.trim();
    }
    public String getHomeCountry() {
        if (homeCountry == null || StringUtils.isEmpty(homeCountry.trim())){
            return  null;
        }
        return homeCountry.trim().toUpperCase();
    }

    public Integer getType(){
        if(type != 1 && type != 2){
            type = 0;
        }
        return type;
    }
}
