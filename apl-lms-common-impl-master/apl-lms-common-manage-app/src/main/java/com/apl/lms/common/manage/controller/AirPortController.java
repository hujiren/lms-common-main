package com.apl.lms.common.manage.controller;


import com.apl.lms.common.query.manage.dto.AirPortAddDto;
import com.apl.lms.common.query.manage.dto.AirPortKeyDto;
import com.apl.lms.common.query.manage.dto.AirPortUpdDto;
import com.apl.lms.common.query.manage.vo.AirPortListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.apl.lib.pojo.dto.PageDto;
import org.springframework.web.bind.annotation.*;
import com.apl.lms.common.service.AirPortService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;

/**
 *
 * @author cy
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/air-port")
@Validated
@Api(value = "空运机场",tags = "空运机场")
@Slf4j
public class AirPortController {

    @Autowired
    public AirPortService airPortService;

    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="CODE_EXIST -> portCode已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtil<String> add(AirPortAddDto airPortAddDto) {

        ApiParamValidate.validate(airPortAddDto);
        String portCode =  airPortAddDto.getPortCode().toUpperCase();
        String homeCountry = airPortAddDto.getHomeCountry().toUpperCase();
        airPortAddDto.setHomeCountry(homeCountry);
        airPortAddDto.setPortCode(portCode);

        return airPortService.add(airPortAddDto);

    }

    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="CODE_EXIST -> portCode已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtil<Boolean> upd(AirPortUpdDto airPortUpdDto) {

        ApiParamValidate.validate(airPortUpdDto);
        String oldCode = airPortUpdDto.getOldCode().toUpperCase();
        String portCode = airPortUpdDto.getPortCode().toUpperCase();
        String homeCountry = airPortUpdDto.getHomeCountry().toUpperCase();
        airPortUpdDto.setHomeCountry(homeCountry);
        airPortUpdDto.setOldCode(oldCode);
        airPortUpdDto.setPortCode(portCode);

        return airPortService.updByCode(airPortUpdDto);

    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "portCode",value = " 机场简码", required = true)
    public ResultUtil<Boolean> del(String portCode) {

        ApiParamValidate.notEmpty("portCode", portCode);
        String portCodeStr =  portCode.toUpperCase();

        return airPortService.delByCode(portCodeStr);

    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "portCode",value = "机场简码", required = true)
    public ResultUtil<AirPortAddDto> get(String portCode) {

        ApiParamValidate.notEmpty("portCode", portCode);
        String portCodeStr = portCode.toUpperCase();

        return airPortService.selectByCode(portCodeStr);

    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<AirPortListVo>> getList(PageDto pageDto, @Validated AirPortKeyDto airPortKeyDto) {

        return airPortService.getList(pageDto , airPortKeyDto);

    }

}
