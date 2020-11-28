package com.apl.lms.common.manage.controller;


import com.apl.lms.common.query.manage.dto.AirCarrierDto;
import com.apl.lms.common.query.manage.dto.AirCarrierKeyDto;
import com.apl.lms.common.service.AirCarrierService;
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
@RequestMapping("/air-carrier")
@Validated
@Api(value = "航空公司",tags = "航空公司")
@Slf4j
public class AirCarrierController {

    @Autowired
    public AirCarrierService airCarrierService;

    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="CODE_EXIST -> code已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtil<Integer> add(AirCarrierDto airCarrierDto) {
        ApiParamValidate.validate(airCarrierDto);
        String carrierCode = airCarrierDto.getCarrierCode().toUpperCase();
        airCarrierDto.setCarrierCode(carrierCode);
        return airCarrierService.add(airCarrierDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="CODE_EXIST -> code已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "query")
    public ResultUtil<Boolean> upd(AirCarrierDto airCarrierDto) {
        ApiParamValidate.validate(airCarrierDto);
        ApiParamValidate.notEmpty("id", airCarrierDto.getId());
        String carrierCode = airCarrierDto.getCarrierCode().toUpperCase();
        airCarrierDto.setCarrierCode(carrierCode);
        return airCarrierService.updById(airCarrierDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true, paramType = "query")
    public ResultUtil<Boolean> del(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {
        ApiParamValidate.notEmpty("id", id);
        return airCarrierService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtil<AirCarrierDto> get(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {
        ApiParamValidate.notEmpty("id", id);
        return airCarrierService.selectById(id);
    }

    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<AirCarrierDto>> getList(PageDto pageDto, AirCarrierKeyDto airCarrierKeyDto) {
        return airCarrierService.getList(pageDto , airCarrierKeyDto);
    }


}
