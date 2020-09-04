package com.apl.lms.common.manage.controller;


import com.apl.lms.common.query.manage.dto.SeaPortDto;
import com.apl.lms.common.query.manage.dto.SeaPortKeyDto;
import com.apl.lms.common.query.manage.vo.SeaPortListVo;
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
import com.apl.lms.common.service.SeaPortService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cy
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/sea-port")
@Validated
@Api(value = "海运港口",tags = "海运港口")
@Slf4j
public class SeaPortController {

    @Autowired
    public SeaPortService seaPortService;

    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="CODE_EXIST -> code已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtil<Integer> add(SeaPortDto seaPortDto) {
        ApiParamValidate.validate(seaPortDto);
        String portCode = seaPortDto.getPortCode().toUpperCase();
        String homeCountry =  seaPortDto.getHomeCountry().toUpperCase();
        seaPortDto.setHomeCountry(homeCountry);
        seaPortDto.setPortCode(portCode);
        return seaPortService.add(seaPortDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="CODE_EXIST -> code已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtil<Boolean> upd(SeaPortDto seaPortDto) {
        ApiParamValidate.validate(seaPortDto);
        ApiParamValidate.notEmpty("id", seaPortDto.getId());
        String homeCountry = seaPortDto.getHomeCountry().toUpperCase();
        String portCode = seaPortDto.getPortCode().toUpperCase();
        seaPortDto.setPortCode(portCode);
        seaPortDto.setHomeCountry(homeCountry);
        return seaPortService.updById(seaPortDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",paramType = "query")
    public ResultUtil<Boolean> del(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {
        ApiParamValidate.notEmpty("id", id);
        return seaPortService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtil<SeaPortDto> get(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {
        ApiParamValidate.notEmpty("id", id);
        return seaPortService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<SeaPortListVo>> getList(PageDto pageDto, SeaPortKeyDto seaPortKeyDto) {
        return seaPortService.getList(pageDto , seaPortKeyDto);
    }

}
