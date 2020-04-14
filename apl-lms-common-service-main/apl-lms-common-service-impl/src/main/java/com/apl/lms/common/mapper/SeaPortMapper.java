package com.apl.lms.common.mapper;

import com.apl.lms.common.dto.SeaPortKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 海港 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
public interface SeaPortMapper extends BaseMapper<SeaPortKeyDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public SeaPortKeyDto getById(@Param("id" ) Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<SeaPortKeyDto> getList(Page page, @Param("kd" ) SeaPortKeyDto seaPortKeyDto);



}
