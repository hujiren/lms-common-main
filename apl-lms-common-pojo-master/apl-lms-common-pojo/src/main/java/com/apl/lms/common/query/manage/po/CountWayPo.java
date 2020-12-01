package com.apl.lms.common.query.manage.po;

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
 *  计件方式 持久化对象
 * </p>
 *
 * @author arran
 * @since 2020-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("count_way")
@ApiModel(value=" 计件方式 持久化对象", description="计件方式 持久化对象")
public class CountWayPo extends Model<CountWayPo> implements Serializable{

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(name = "code" , value = "代码" , required = true)
    @NotEmpty(message = "代码不能为空")
    private String code;

    @ApiModelProperty(name = "nameCn" , value = "中文名称" , required = true)
    @NotEmpty(message = "中文名称不能为空")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名称" , required = true)
    @NotEmpty(message = "英文名称不能为空")
    private String nameEn;

    @ApiModelProperty(name = "way" , value = "计件方式" , required = true)
    private Integer way;

    @ApiModelProperty(name = "pieceUpperCarry" , value = "单件上进位" , required = true)
    private Integer pieceUpperCarry;

    @ApiModelProperty(name = "totalUpperCarry" , value = "合计上进位" , required = true)
    private Integer totalUpperCarry;

    @ApiModelProperty(name = "smallCargoCarry" , value = "小货进位重" )
    @Min(value = 0 , message = "小货进位重不合法")
    private Float smallCargoCarry;

    @ApiModelProperty(name = "bigCargoCarry" , value = "大货进位重")
    @Min(value = 0 , message = "大货进位重不合法")
    private Float bigCargoCarry;

    @ApiModelProperty(name = "bulkyCode" , value = "计泡代码" )
    private String bulkyCode;

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
