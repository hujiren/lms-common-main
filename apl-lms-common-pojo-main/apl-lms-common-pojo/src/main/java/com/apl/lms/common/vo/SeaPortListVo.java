package com.apl.lms.common.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class SeaPortListVo extends Model<SeaPortListVo> {

    private Long id;

    private String portCode;

    private String nameCn;

    private String nameEn;

    private String homeCountry;

    private String  aliasName;

    private String  countryNameCn;

    private String  countryNameEn;

    private static final long serialVersionUID=1L;

}
