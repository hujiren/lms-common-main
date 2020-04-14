package com.apl.devops.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 商品单位
 * </p>
 *
 * @author cy
 * @since 2019-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("commodity_unit")
@ApiModel(value="CommodityUnitPo对象", description="商品单位")
public class CommodityUnitPo extends Model<CommodityUnitPo> {

private static final long serialVersionUID=1L;

    @ApiModelProperty(name = "id" , value = "单位id" , required = true)
    @Min(value = 0 , message = "单位id 不能小于1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "commodityUnit" , value = "单位" , required = true)
    @NotEmpty(message = "单位 不能为空")
    private String commodityUnit;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
