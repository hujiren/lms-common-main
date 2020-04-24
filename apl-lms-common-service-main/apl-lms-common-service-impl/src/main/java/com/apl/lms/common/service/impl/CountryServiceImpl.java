package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.exception.AplException;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.CountryDto;
import com.apl.lms.common.dto.CountryKeyDto;
import com.apl.lms.common.dto.CountryUpdDto;
import com.apl.lms.common.mapper.CountryMapper;
import com.apl.lms.common.service.CountryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import springfox.documentation.annotations.Cacheable;

import java.util.List;


/**
 * <p>
 * 国家 service实现类
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class CountryServiceImpl extends ServiceImpl<CountryMapper, CountryDto> implements CountryService {

    //状态code枚举
    /*enum CountryServiceCode {

        ;

        private String code;
        private String msg;

        CountryServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public ResultUtils<String> addCountry(CountryDto countryDto){

        this.exists(null, countryDto.getCountryCode(), countryDto.getNameCn(),  countryDto.getNameEn() );

        Integer flag = countryMapper.insert(countryDto);

        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , countryDto.getCountryCode());
        }
        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updateCountryByCode(CountryUpdDto countryUpdDto){

        this.exists(countryUpdDto.getOldCode(),  countryUpdDto.getCountryCode(), countryUpdDto.getNameCn(),  countryUpdDto.getNameEn() );

        CountryDto countryDto = new CountryDto();
        BeanUtils.copyProperties(countryUpdDto, countryDto);

        UpdateWrapper<CountryDto> wrapper = new UpdateWrapper <>();
        wrapper.eq("country_code", countryUpdDto.getOldCode());
        Integer flag = countryMapper.update(countryDto, wrapper);

        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , false);
    }


    @Override
    public ResultUtils<Boolean> deleteCountryByCode(String countryCode){

        Boolean flag = countryMapper.deleteCountryByCode(countryCode);

        if(flag){
            return ResultUtils.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.DEL_FAIL , false);
    }

    @Override
    public ResultUtils<Page<CountryDto>> getListCountryByPage(PageDto pageDto, CountryKeyDto keyDto){

        Page<CountryDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<CountryDto> list = baseMapper.getListCountryByPage(page , keyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS , page);
    }


    void exists(String oldCode, String countryCode, String nameCn, String nameEn) {

        List<CountryDto> list = baseMapper.exists(countryCode, nameCn,  nameEn);

        if (!CollectionUtils.isEmpty(list)) {
            for(CountryDto  dto : list) {

                if(oldCode==null || !dto.getCountryCode().equals(oldCode)) {
                    if(dto.getCountryCode().equals(countryCode))
                        throw new AplException("COUNTRY_CODE_EXIST", "countryCode已经存在");

                    if(dto.getNameCn().equals(nameCn))
                        throw new AplException("NAME_CN_EXIST", "nameCn已经存在");

                    if(dto.getNameEn().equals(nameEn))
                        throw new AplException("NAME_EN_EXIST", "nameEn已经存在");
                }
            }
        }
    }


}
