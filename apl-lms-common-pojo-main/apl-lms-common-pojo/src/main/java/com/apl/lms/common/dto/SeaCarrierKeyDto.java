package com.apl.lms.common.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 般公司 持久化对象
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sea_carrier")
@ApiModel(value="般公司 持久化对象", description="般公司 持久化对象")
public class SeaCarrierKeyDto extends Model<SeaCarrierKeyDto> {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String carrierCode;

    private String nameCn;

    private String nameEn;

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
