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
 *  计件方式 分页对象
 * </p>
 *
 * @author arran
 * @since 2020-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("count_way")
@ApiModel(value="CountWayKeyDto 分页对象", description="计件方式")
public class CountWayKeyDto extends Model<CountWayKeyDto> {

    @ApiModelProperty(name = "keyword", value = "关键词")
    private String keyword;

    public String getKeyword() {
        if (keyword == null || StringUtils.isEmpty(keyword.trim())){
            return  null;
        }

        return keyword.trim();
    }

}
