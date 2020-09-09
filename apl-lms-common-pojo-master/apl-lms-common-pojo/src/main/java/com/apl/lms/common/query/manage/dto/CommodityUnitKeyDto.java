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
 * 商品单位 分页对象
 * </p>
 *
 * @author cy
 * @since 2019-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("commodity_unit")
@ApiModel(value="CommodityUnitKeyDto查询对象", description="商品单位")
public class CommodityUnitKeyDto extends Model<CommodityUnitKeyDto> {

    @ApiModelProperty(name = "keyword", value = "关键词")
    private String keyword;

    @ApiModelProperty(name = "upperKeyword", value = "大写关键词",hidden = true)
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
