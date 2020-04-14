package com.apl.lms.common.controller;


import com.apl.lms.common.dto.SeaCarrierKeyDto;
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
import com.apl.lms.common.service.SeaCarrierService;
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
@RequestMapping("/sea-carrier")
@Validated
@Api(value = "般公司",tags = "般公司")
@Slf4j
public class SeaCarrierController {

    @Autowired
    public SeaCarrierService seaCarrierService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="")
    public ResultUtils<Integer> add(SeaCarrierKeyDto seaCarrierKeyDto) {
        ApiParamValidate.validate(seaCarrierKeyDto);

        return seaCarrierService.add(seaCarrierKeyDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="")
    public ResultUtils<Boolean> updById(SeaCarrierKeyDto seaCarrierKeyDto) {
        ApiParamValidate.notEmpty("id", seaCarrierKeyDto.getId());
        ApiParamValidate.validate(seaCarrierKeyDto);

        return seaCarrierService.updById(seaCarrierKeyDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return seaCarrierService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtils<SeaCarrierKeyDto> selectById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return seaCarrierService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtils<Page<SeaCarrierKeyDto>> getList(PageDto pageDto, @Validated SeaCarrierKeyDto seaCarrierKeyDto) {

        return seaCarrierService.getList(pageDto , seaCarrierKeyDto);
    }

}
