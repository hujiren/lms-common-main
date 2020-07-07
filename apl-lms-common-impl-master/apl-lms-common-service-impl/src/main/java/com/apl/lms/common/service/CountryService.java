package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtil;

import com.apl.lms.common.query.manage.dto.CountryDto;
import com.apl.lms.common.query.manage.dto.CountryKeyDto;
import com.apl.lms.common.query.manage.dto.CountryUpdDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 国家 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
public interface CountryService extends IService<CountryDto> {

        /**
         * @Desc: 添加一个CountryPo实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<String> addCountry(CountryDto countryDto);


        /**
         * @Desc: 根据id 更新一个CountryPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> updateCountryByCode(CountryUpdDto countryUpdDto);


        /**
         * @Desc: 根据id 查找一个CountryPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> deleteCountryByCode(String countryCode);


        /**
         * @Desc: 分页查找 CountryPo 列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Page<CountryDto>>getListCountryByPage(PageDto pageDto, CountryKeyDto keyDto);

}
