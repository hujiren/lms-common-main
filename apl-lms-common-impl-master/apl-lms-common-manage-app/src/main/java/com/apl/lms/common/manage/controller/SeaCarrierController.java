package com.apl.lms.common.manage.controller;


import com.apl.lms.common.query.manage.dto.SeaCarrierDto;
import com.apl.lms.common.query.manage.dto.SeaCarrierKeyDto;
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
@Api(value = "船舶公司",tags = "船舶公司")
@Slf4j
public class SeaCarrierController {

    @Autowired
    public SeaCarrierService seaCarrierService;

    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="CODE_EXIST -> code已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtils<Integer> add(SeaCarrierDto seaCarrierDto) {
        ApiParamValidate.validate(seaCarrierDto);
        String carrierCode = seaCarrierDto.getCarrierCode().toUpperCase();
        seaCarrierDto.setCarrierCode(carrierCode);
        return seaCarrierService.add(seaCarrierDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="CODE_EXIST -> code已经存在\n"+
            "NAME_CN_EXIST -> nameCn已经存在\n"+
            "NAME_EN_EXIST -> nameEn已经存在")
    public ResultUtils<Boolean> updById(SeaCarrierDto seaCarrierDto) {
        ApiParamValidate.validate(seaCarrierDto);
        ApiParamValidate.notEmpty("id", seaCarrierDto.getId());
        String carrierCode = seaCarrierDto.getCarrierCode().toUpperCase();
        seaCarrierDto.setCarrierCode(carrierCode);

        return seaCarrierService.updById(seaCarrierDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {
        ApiParamValidate.notEmpty("id", id);
        return seaCarrierService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtils<SeaCarrierDto> selectById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {
        ApiParamValidate.notEmpty("id", id);
        return seaCarrierService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtils<Page<SeaCarrierDto>> getList(PageDto pageDto, @Validated SeaCarrierKeyDto seaCarrierKeyDto) {
        return seaCarrierService.getList(pageDto , seaCarrierKeyDto);
    }

}
