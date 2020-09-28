package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.CountryAddDto;
import com.apl.lms.common.query.manage.dto.CountryKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 国家 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Repository
public interface CountryMapper extends BaseMapper<CountryAddDto> {

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<CountryAddDto> getListCountryByPage(Page page, @Param("key") CountryKeyDto countryKeyDto);

    /**
     * @Desc: 检测记录是否重复
     * @Author: ${cfg.author}
     * @Date: 2020-04-16
     */
    List<CountryAddDto> exists(@Param("countryCode") String countryCode, @Param("nameCn") String nameCn, @Param("nameEn") String nameEn);

    /**
     * @Desc: 删除
     * @Author: ${cfg.author}
     * @Date: 2020-04-16
     */
    Boolean deleteCountryByCode(String  countryCode);
}
