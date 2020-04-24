package com.apl.lms.common.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;


/**
 * <p>
 * 机场 分页对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("air_port")
@ApiModel(value="AirPortKeyDto 分页对象", description="机场")
public class AirPortKeyDto extends Model<AirPortKeyDto> {

    @ApiModelProperty(name = "keyword", value = "关键词")
    @Length(max = 100, message = "关键词长度不能超过100")
    private String keyword;

    @ApiModelProperty(name = "homeCountry", value = "所属国家")
    @Length(max = 3, message = "所属国家长度不能超过3")
    private String homeCountry;

    public String getHomeCountry() {
        if (homeCountry == null || StringUtils.isEmpty(homeCountry.trim())){
            return  null;
        }
        return homeCountry.trim().toUpperCase();
    }

    public String getKeyword() {
        if (keyword == null ||StringUtils.isEmpty(keyword.trim())){
            return  null;
        }
        return keyword.trim();
    }

}
