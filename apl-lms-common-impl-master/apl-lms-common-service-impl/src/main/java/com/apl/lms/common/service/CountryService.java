package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtil;

import com.apl.lms.common.query.manage.dto.CountryAddDto;
import com.apl.lms.common.query.manage.dto.CountryKeyDto;
import com.apl.lms.common.query.manage.dto.CountryUpdDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.IOException;

/**
 * <p>
 * 国家 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
public interface CountryService extends IService<CountryAddDto> {

        /**
         * @Desc: 添加
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<String> addCountry(CountryAddDto countryAddDto);


        /**
         * @Desc: 更新
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> updateCountryByCode(CountryUpdDto countryUpdDto);


        /**
         * @Desc: 删除
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> deleteCountryByCode(String countryCode);


        /**
         * @Desc: 分页查找列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Page<CountryAddDto>>getListCountryByPage(PageDto pageDto, CountryKeyDto keyDto) throws IOException;

}
