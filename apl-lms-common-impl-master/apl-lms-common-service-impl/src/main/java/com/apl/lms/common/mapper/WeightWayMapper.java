package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 航空公司 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Mapper
@Repository
public interface WeightWayMapper extends BaseMapper<WeightWayDto> {

    /**
     * @Desc: 查找计泡方式列表
     * @Author:
     * @Date: 2020-08-08
     */
    List<WeightWayDto> getList(Page page, @Param("key") WeightWayKeyDto weightWayKeyDto);






}
