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
 * 航空公司 持久化对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("common_air_carrier")
@ApiModel(value="航空公司-交互对象", description="航空公司-交互对象")
public class AirCarrierDto extends Model<AirCarrierDto> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "carrierCode" , value = "航空公司简码")
    @NotEmpty(message = "航空公司简码不能为空")
    @Length(max = 6, message = "航空公司简码长度不能超过6")
    private String carrierCode;

    @ApiModelProperty(name = "nameCn" , value = "中文名")
    @NotEmpty(message = "中文名不能为空")
    @Length(max = 100, message = "中文名长度不能超过100")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名")
    @NotEmpty(message = "英文名不能为空")
    @Length(max = 100, message = "英文名长度不能超过100")
    private String nameEn;

    private static final long serialVersionUID=1L;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
