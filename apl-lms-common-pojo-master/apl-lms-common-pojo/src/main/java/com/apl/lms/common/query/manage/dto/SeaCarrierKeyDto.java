package com.apl.lms.common.query.manage.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 般公司 分页对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sea_carrier")
@ApiModel(value="船公司 分页对象", description="般公司 分页对象")
public class SeaCarrierKeyDto extends Model<SeaCarrierKeyDto> {

    @ApiModelProperty(name = "keyword", value = "关键词")
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
