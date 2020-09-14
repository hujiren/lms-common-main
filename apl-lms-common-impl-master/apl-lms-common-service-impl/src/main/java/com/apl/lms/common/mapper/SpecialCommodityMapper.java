package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.SpecialCommodityDto;
import com.apl.lms.common.query.manage.dto.SpecialCommodityKeyDto;
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
public interface SpecialCommodityMapper extends BaseMapper<SpecialCommodityDto> {

    /**
     * @Desc: 查找特殊物品列表
     * @Author:
     * @Date: 2020-08-08
     */
    List<SpecialCommodityDto> getList(Page page, @Param("key") SpecialCommodityKeyDto specialCommodityKeyDto);


}
