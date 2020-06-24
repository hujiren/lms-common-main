package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.CountWayDto;
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
public interface CountWayMapper extends BaseMapper<CountWayDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-03-30
     */
    CountWayDto getById(@Param("id") Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-03-30
     */
    List<CountWayDto> getList();


}
