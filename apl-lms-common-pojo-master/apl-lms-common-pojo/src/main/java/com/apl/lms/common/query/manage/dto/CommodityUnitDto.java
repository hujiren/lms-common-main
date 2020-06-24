package com.apl.lms.common.query.manage.dto;

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
 * 商品单位 持久化对象
 * </p>
 *
 * @author cy
 * @since 2019-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("commodity_unit")
@ApiModel(value="CommodityUnitPo实体对象", description="商品单位")
public class CommodityUnitDto extends Model<CommodityUnitDto> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(name = "id" , value = "单位id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "unitCode" , value = "单位")
    @NotEmpty(message = "单位 不能为空")
    @Length(max = 10, message = "单位长度不能超过10")
    private String unitCode;

    @ApiModelProperty(name = "unitName" , value = "单位名称")
    @NotEmpty(message = "单位名称不能为空")
    @Length(max = 11, message = "单位名称长度不能超过11")
    private String unitName;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
