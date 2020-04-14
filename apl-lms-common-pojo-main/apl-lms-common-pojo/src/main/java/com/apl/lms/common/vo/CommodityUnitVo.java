package com.apl.org.sys.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class CommodityUnitVo implements Serializable {

    @ApiModelProperty(name = "id" , value = "单位id")
    private Long id;

    @ApiModelProperty(name = "unitCode" , value = "单位code" )
    private String unitCode;

    @ApiModelProperty(name = "unitName" , value = "单位名称")
    private String unitName;

}
