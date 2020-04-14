package com.apl.lms.common.mapper;

import com.apl.lms.common.dto.CountWayKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author arran
 * @since 2020-03-30
 */
public interface CountWayMapper extends BaseMapper<CountWayKeyDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-03-30
     */
    CountWayKeyDto getById(@Param("id") Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-03-30
     */
    List<CountWayKeyDto> getList();



}
