package com.apl.lms.common.manage.controller;


import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.query.manage.dto.CommodityUnitDto;
import com.apl.lms.common.query.manage.dto.CommodityUnitKeyDto;
import com.apl.lms.common.service.CommodityUnitService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author arran
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/commodity-unit")
@Validated
@Api(value = "单位管理",tags = "单位管理")
@Slf4j
public class UnitController {

    @Autowired
    public CommodityUnitService commodityUnitService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="UNIT_CODE_EXIST -> unitCode已经存在\n"+
                                            "UNIT_NAME_EXIST -> unitName已经存在")
    public ResultUtil<Integer> add(CommodityUnitDto commodityUnitDto) throws Exception {

        ApiParamValidate.validate(commodityUnitDto);
        String str = commodityUnitDto.getUnitCode().toUpperCase();
        commodityUnitDto.setUnitCode(str);

        return commodityUnitService.add(commodityUnitDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="UNIT_CODE_EXIST -> unitCode已经存在\n"+
                                                "UNIT_NAME_EXIST -> unitName已经存在")
    public ResultUtil<Boolean> upd(CommodityUnitDto commodityUnitDto) throws Exception {

        ApiParamValidate.notEmpty("id", commodityUnitDto.getId());
        ApiParamValidate.validate(commodityUnitDto);
        String str = commodityUnitDto.getUnitCode().toUpperCase();
        commodityUnitDto.setUnitCode(str);

        return commodityUnitService.updateUnitById(commodityUnitDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtil<Boolean> del(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) throws Exception {

        ApiParamValidate.notEmpty("id", id);

        return commodityUnitService.deleteUnitById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtil<CommodityUnitDto> get(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        ApiParamValidate.notEmpty("id", id);

        return commodityUnitService.selectUnitById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<CommodityUnitDto>> getList(PageDto pageDto, @Validated CommodityUnitKeyDto keyDto) throws Exception {

        return commodityUnitService.getUnitByPage(pageDto , keyDto);
    }

}
