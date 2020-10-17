package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.exception.AplException;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.CountryAddDto;
import com.apl.lms.common.query.manage.dto.CountryKeyDto;
import com.apl.lms.common.query.manage.dto.CountryUpdDto;
import com.apl.lms.common.mapper.CountryMapper;
import com.apl.lms.common.service.CountryService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class CountryServiceImpl extends ServiceImpl<CountryMapper, CountryAddDto> implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    /**
     * 新增
     * @param countryAddDto
     * @return
     */
    @Override
    public ResultUtil<String> addCountry(CountryAddDto countryAddDto){

        this.exists(null, countryAddDto.getCountryCode(), countryAddDto.getNameCn(),  countryAddDto.getNameEn() );
        if(countryAddDto.getCountryCode() != null){
            countryAddDto.setCountryCode(countryAddDto.getCountryCode().toUpperCase());
        }
        if(countryAddDto.getHomeCountry() != null){
            countryAddDto.setHomeCountry(countryAddDto.getHomeCountry().toUpperCase());
        }
        Integer flag = countryMapper.insert(countryAddDto);

        if(flag > 0){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , countryAddDto.getCountryCode());
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }

    /**
     * 修改
     * @param countryUpdDto
     * @return
     */
    @Override
    public ResultUtil<Boolean> updateCountryByCode(CountryUpdDto countryUpdDto){

        this.exists(countryUpdDto.getOldCode(),  countryUpdDto.getCountryCode(), countryUpdDto.getNameCn(),  countryUpdDto.getNameEn() );
        if(countryUpdDto.getCountryCode() != null){
            countryUpdDto.setCountryCode(countryUpdDto.getCountryCode().toUpperCase());
        }
        if(countryUpdDto.getHomeCountry() != null){
            countryUpdDto.setHomeCountry(countryUpdDto.getHomeCountry().toUpperCase());
        }
        if(countryUpdDto.getOldCode() != null){
            countryUpdDto.setOldCode(countryUpdDto.getOldCode().toUpperCase());
        }
        CountryAddDto countryAddDto = new CountryAddDto();
        BeanUtils.copyProperties(countryUpdDto, countryAddDto);

        UpdateWrapper<CountryAddDto> wrapper = new UpdateWrapper <>();
        wrapper.eq("country_code", countryUpdDto.getOldCode());
        Integer flag = countryMapper.update(countryAddDto, wrapper);

        if(flag > 0){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtil.APPRESULT("OLD_CODE_IS_NOT_EXISTS","旧简码不存在" , false);
    }

    /**
     * 删除
     * @param countryCode
     * @return
     */
    @Override
    public ResultUtil<Boolean> deleteCountryByCode(String countryCode){

        countryCode = countryCode.toUpperCase();
        Boolean flag = countryMapper.deleteCountryByCode(countryCode);

        if(flag){
            return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }

        return ResultUtil.APPRESULT(CommonStatusCode.DEL_FAIL , false);
    }

    /**
     * 获取列表
     * @param pageDto
     * @param keyDto
     * @return
     */
    @Override
    public ResultUtil<Page<CountryAddDto>> getListCountryByPage(PageDto pageDto, CountryKeyDto keyDto){

        Page<CountryAddDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());
        List<CountryAddDto> list = countryMapper.getListCountryByPage(page , keyDto);
        page.setRecords(list);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS , page);
    }


    void exists(String oldCode, String countryCode, String nameCn, String nameEn) {

        List<CountryAddDto> list = baseMapper.exists(countryCode, nameCn,  nameEn);

        if (!CollectionUtils.isEmpty(list)) {
            for(CountryAddDto dto : list) {

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
