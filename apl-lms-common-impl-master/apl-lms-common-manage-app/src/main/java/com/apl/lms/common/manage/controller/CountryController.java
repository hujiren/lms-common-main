package com.apl.lms.common.manage.controller;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.query.manage.dto.CountryAddDto;
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

import java.io.IOException;

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


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="CODE_EXIST -> countryCode已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtil<String> add(CountryAddDto countryAddDto) {

        ApiParamValidate.validate(countryAddDto);
        return countryService.addCountry(countryAddDto);

    }

    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="CODE_EXIST -> countryCode已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtil<Boolean> upd(CountryUpdDto countryUpdDto) {



        ApiParamValidate.validate(countryUpdDto);
        return countryService.updateCountryByCode(countryUpdDto);

    }

    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "countryCode",value = " 国家简码", required = true)
    public ResultUtil<Boolean> del(String countryCode) {

        ApiParamValidate.notEmpty("countryCode", countryCode);
        return countryService.deleteCountryByCode(countryCode);

    }

    @PostMapping("/get-List")
    @ApiOperation(value =  "国家分页查找" , notes = "国家分页查找")
    public ResultUtil<Page<CountryAddDto>> getList(PageDto pageDto, CountryKeyDto keyDto) throws IOException {

        return countryService.getListCountryByPage(pageDto, keyDto);
    }

}

