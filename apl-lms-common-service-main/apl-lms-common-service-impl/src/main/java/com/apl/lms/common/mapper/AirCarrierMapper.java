package com.apl.lms.common.mapper;

import com.apl.lms.common.dto.AirCarrierKeyDto;
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
public interface AirCarrierMapper extends BaseMapper<AirCarrierKeyDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public AirCarrierKeyDto getById(@Param("id" ) Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<AirCarrierKeyDto> getList(Page page, @Param("kd" ) AirCarrierKeyDto airCarrierKeyDto);



}
