package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.AirCarrierDto;
import com.apl.lms.common.query.manage.dto.AirCarrierKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 航空公司 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
public interface AirCarrierMapper extends BaseMapper<AirCarrierDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public AirCarrierDto getById(@Param("id" ) Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<AirCarrierDto> getList(Page page, @Param("key") AirCarrierKeyDto airCarrierKeyDto);

    /**
     * @Desc: 检测记录是否重复
     * @Author: ${cfg.author}
     * @Date: 2020-04-17
     */
    List<AirCarrierDto> exists(@Param("id") Long id, @Param("carrierCode") String carrierCode, @Param("nameCn") String nameCn, @Param("nameEn") String nameEn );
}
