package com.apl.lms.common.mapper;

import com.apl.lms.common.dto.AirPortKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 机场 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
public interface AirPortMapper extends BaseMapper<AirPortKeyDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public AirPortKeyDto getById(@Param("id" ) Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<AirPortKeyDto> getList(Page page, @Param("kd" ) AirPortKeyDto airPortKeyDto);



}
