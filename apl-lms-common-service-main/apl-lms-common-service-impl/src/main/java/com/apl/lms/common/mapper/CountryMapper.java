package com.apl.lms.common.mapper;

import com.apl.lms.common.dto.CountryKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 国家 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
public interface CountryMapper extends BaseMapper<CountryKeyDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public CountryKeyDto getById(@Param("id" ) Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<CountryKeyDto> getList(Page page, @Param("kd" ) CountryKeyDto countryKeyDto);



}
