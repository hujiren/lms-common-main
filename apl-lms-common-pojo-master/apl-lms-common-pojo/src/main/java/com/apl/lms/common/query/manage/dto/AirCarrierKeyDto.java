package com.apl.lms.common.query.manage.dto;

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
 * 航空公司 分页对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("air_carrier")
@ApiModel(value="航空公司 分页对象", description="航空公司 分页对象")
public class AirCarrierKeyDto extends Model<AirCarrierKeyDto> {

    @ApiModelProperty(name = "keyword", value = "关键词")
    @Length(max = 100, message = "关键词长度不能超过100")
    private String keyword;

    @ApiModelProperty(name = "upperKeyword", value = "大写关键词", hidden = true)
    private String upperKeyword;

    public String getKeyword() {
        if (keyword == null || StringUtils.isEmpty(keyword.trim())){
            return  null;
        }
        return keyword.trim();
    }

    public String getUpperKeyword() {
        if (keyword == null || StringUtils.isEmpty(keyword.trim())){
            return  null;
        }
        return keyword.toUpperCase().trim();
    }
}
