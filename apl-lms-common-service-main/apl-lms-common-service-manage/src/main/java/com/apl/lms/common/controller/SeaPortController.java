package com.apl.lms.common.controller;


import com.apl.lms.common.dto.SeaPortKeyDto;
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
import com.apl.lib.utils.ResultUtils;
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
@Api(value = "海港",tags = "海港")
@Slf4j
public class SeaPortController {

    @Autowired
    public SeaPortService seaPortService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="")
    public ResultUtils<Integer> add(SeaPortKeyDto seaPortKeyDto) {
        ApiParamValidate.validate(seaPortKeyDto);

        return seaPortService.add(seaPortKeyDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="")
    public ResultUtils<Boolean> updById(SeaPortKeyDto seaPortKeyDto) {
        ApiParamValidate.notEmpty("id", seaPortKeyDto.getId());
        ApiParamValidate.validate(seaPortKeyDto);

        return seaPortService.updById(seaPortKeyDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return seaPortService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtils<SeaPortKeyDto> selectById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return seaPortService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtils<Page<SeaPortKeyDto>> getList(PageDto pageDto, @Validated com.apl.lms.common.dto.SeaPortKeyDto seaPortKeyDto) {

        return seaPortService.getList(pageDto , seaPortKeyDto);
    }

}
