package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtils;

import com.apl.lms.common.dto.CountryKeyDto;
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
public interface CountryService extends IService<CountryKeyDto> {

        /**
         * @Desc: 添加一个CountryPo实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Integer> add(CountryKeyDto countryKeyDto);


        /**
         * @Desc: 根据id 更新一个CountryPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> updById(CountryKeyDto countryKeyDto);


        /**
         * @Desc: 根据id 查找一个CountryPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> delById(Long id);


        /**
         * @Desc: 根据id 查找一个 CountryPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<CountryKeyDto> selectById(Long id);


        /**
         * @Desc: 分页查找 CountryPo 列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Page<CountryKeyDto>>getList(PageDto pageDto, CountryKeyDto countryKeyDto);

}
