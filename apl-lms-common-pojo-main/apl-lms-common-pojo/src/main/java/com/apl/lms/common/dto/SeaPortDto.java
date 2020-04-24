package com.apl.lms.common.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 海港 持久化对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sea_port")
@ApiModel(value="SeaPortDto 持久化对象", description="海港")
public class SeaPortDto extends Model<SeaPortDto> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "portCode" , value = "海港简码", required = true)
    @NotEmpty(message = "海港简码不能为空")
    @Length(max = 6, message = "海港简码长度不能超过6")
    private String portCode;

    @ApiModelProperty(name = "nameCn" , value = "中文名", required = true)
    @NotEmpty(message = "中文名不能为空")
    @Length(max = 100, message = "中文名长度不能超过100")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名", required = true)
    @NotEmpty(message = "英文名不能为空")
    @Length(max = 100, message = "英文名长度不能超过3")
    private String nameEn;

    @ApiModelProperty(name = "homeCountry" , value = "所属国家", required = true)
    @NotEmpty(message = "所属国家不能为空")
    @Length(max = 3, message = "所属国家长度不能超过3")
    private String homeCountry;

    @ApiModelProperty(name = "aliasName" , value = "别名")
    @Length(max = 200, message = "别名长度不能超过200")
    private String  aliasName;

    private static final long serialVersionUID=1L;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
