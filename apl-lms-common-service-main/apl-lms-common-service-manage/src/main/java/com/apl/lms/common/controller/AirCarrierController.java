package com.apl.lms.common.controller;


import com.apl.lms.common.dto.AirCarrierKeyDto;
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
import com.apl.lms.common.service.AirCarrierService;
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
@RequestMapping("/air-carrier")
@Validated
@Api(value = "航空公司",tags = "航空公司")
@Slf4j
public class AirCarrierController {

    @Autowired
    public AirCarrierService airCarrierService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="")
    public ResultUtils<Integer> add(AirCarrierKeyDto airCarrierKeyDto) {
        ApiParamValidate.validate(airCarrierKeyDto);

        return airCarrierService.add(airCarrierKeyDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="")
    public ResultUtils<Boolean> updById(AirCarrierKeyDto airCarrierKeyDto) {
        ApiParamValidate.notEmpty("id", airCarrierKeyDto.getId());
        ApiParamValidate.validate(airCarrierKeyDto);

        return airCarrierService.updById(airCarrierKeyDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return airCarrierService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtils<AirCarrierKeyDto> selectById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return airCarrierService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtils<Page<AirCarrierKeyDto>> getList(PageDto pageDto, @Validated AirCarrierKeyDto airCarrierKeyDto) {

        return airCarrierService.getList(pageDto , airCarrierKeyDto);
    }

}
