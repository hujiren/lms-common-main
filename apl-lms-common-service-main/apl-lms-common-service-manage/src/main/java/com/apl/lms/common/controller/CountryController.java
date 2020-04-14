package com.apl.lms.common.controller;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.CountryKeyDto;
import com.apl.lms.common.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="")
    public ResultUtils<Integer> add(CountryKeyDto countryKeyDto) {

        return countryService.add(countryKeyDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="BRAND_NAME_EXIST -> brandName已经存在\n"+
                                          "BRAND_NAME_EN_EXIST -> brandNameEn已经存在")
    public ResultUtils<Boolean> updById(CountryKeyDto countryKeyDto) {

        return countryService.updById(countryKeyDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(Long id) {

        return countryService.delById(id);
    }





    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtils<Page<CountryKeyDto>> getList(PageDto pageDto, CountryKeyDto countryKeyDto) {

        return countryService.getList(pageDto, countryKeyDto);
    }

}
