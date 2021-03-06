package com.apl.lms.common.query.controller;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.query.manage.dto.CountryAddDto;
import com.apl.lms.common.query.manage.dto.CountryKeyDto;
import com.apl.lms.common.query.manage.dto.CountryUpdDto;
import com.apl.lms.common.service.CountryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 * @author
 * @since 2020-4-10
 */
@RestController
@RequestMapping("/country")
@Validated
@Api(value = "公共国家",tags = "公共国家")
@Slf4j
public class CountryController {

    @Autowired
    private CountryService countryService;


    @PostMapping("/getList-country")
    @ApiOperation(value =  "国家分页查找" , notes = "国家分页查找")
    public ResultUtil<Page<CountryAddDto>> getListCountryByPage(PageDto pageDto, CountryKeyDto keyDto) throws IOException {
        return countryService.getListCountryByPage(pageDto, keyDto);
    }

}

