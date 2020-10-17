package com.apl.lms.common.query.manage.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 *   计件方式 持久化对象
 * </p>
 *
 * @author arran
 * @since 2020-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("count_way")
@ApiModel(value=" CountWayDto 持久化对象", description="计件方式")
public class CountWayListVo extends Model<CountWayListVo> {


    @TableId(value = "id", type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;

    @ApiModelProperty(name = "code" , value = "代码")
    private String code;

    @ApiModelProperty(name = "nameCn" , value = "中文名称")
    private String nameCn;

    @ApiModelProperty(name = "nameEn" , value = "英文名称")
    private String nameEn;

}
