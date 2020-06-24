package com.apl.lms.common.manage.controller;
import com.apl.lib.utils.ResultUtils;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.query.manage.dto.CountryDto;
import com.apl.lms.common.query.manage.dto.CountryKeyDto;
import com.apl.lms.common.query.manage.dto.CountryUpdDto;
import com.apl.lms.common.service.CountryService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.apl.lib.pojo.dto.PageDto;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 *
 * @author
 * @since 2020-4-10
 */
@RestController
@RequestMapping("/country")
@Validated
@Api(value = "国家",tags = "国家")
@Slf4j
public class CountryController {

    @Autowired
    private CountryService countryService;

    // /country/add-country
    // /country/add
    @PostMapping(value = "/add-country")
    @ApiOperation(value =  "添加", notes ="CODE_EXIST -> countryCode已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtils<String> addCountry(CountryDto countryDto) {
        ApiParamValidate.validate(countryDto);
        String countryCode = countryDto.getCountryCode().toUpperCase();
        countryDto.setCountryCode(countryCode);
        if(!StringUtils.isEmpty(countryDto.getHomeCountry())) {
            String homeCountry = countryDto.getHomeCountry().toUpperCase();
            countryDto.setHomeCountry(homeCountry);
        }
        return countryService.addCountry(countryDto);
    }

    @PostMapping(value = "/update-country")
    @ApiOperation(value =  "更新",  notes ="CODE_EXIST -> countryCode已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtils<Boolean> updateCountryByCode(CountryUpdDto countryUpdDto) {
        ApiParamValidate.validate(countryUpdDto);
        countryUpdDto.getOldCode().toUpperCase();
        countryUpdDto.getCountryCode().toUpperCase();
        if(!StringUtils.isEmpty(countryUpdDto.getHomeCountry())){
            countryUpdDto.getHomeCountry().toUpperCase();
        }
        return countryService.updateCountryByCode(countryUpdDto);
    }

    @PostMapping(value = "/delete-country")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "countryCode",value = " 国家简码", required = true)
    public ResultUtils<Boolean> deleteCountryById(String countryCode) {
        ApiParamValidate.notEmpty("countryCode", countryCode);
        String s = countryCode.toUpperCase();
        return countryService.deleteCountryByCode(s);
    }

    @PostMapping("/getList-country")
    @ApiOperation(value =  "国家分页查找" , notes = "国家分页查找")
    public ResultUtils<Page<CountryDto>> getListCountryByPage(PageDto pageDto, CountryKeyDto keyDto) {
        return countryService.getListCountryByPage(pageDto, keyDto);
    }

}

