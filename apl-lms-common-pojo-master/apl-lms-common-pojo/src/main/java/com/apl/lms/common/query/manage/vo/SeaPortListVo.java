package com.apl.lms.common.query.manage.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="SeaPortDto 持久化对象", description="海港")
public class SeaPortListVo extends Model<SeaPortListVo> {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(name = "id", value = "海港id")
    private Long id;

    @ApiModelProperty(name = "portCode", value = "海港简码")
    private String portCode;

    @ApiModelProperty(name = "nameCn", value = "海港英文名称")
    private String nameCn;

    @ApiModelProperty(name = "nameEn", value = "海港英文名称")
    private String nameEn;

    @ApiModelProperty(name = "homeCountry", value = "所属国家")
    private String homeCountry;

    @ApiModelProperty(name = "aliasName", value = "别名")
    private String  aliasName;

    @ApiModelProperty(name = "countryNameCn", value = "国家中文名称")
    private String  countryNameCn;

    @ApiModelProperty(name = "countryNameEn", value = "国家英文名称")
    private String  countryNameEn;

    private static final long serialVersionUID=1L;

}
