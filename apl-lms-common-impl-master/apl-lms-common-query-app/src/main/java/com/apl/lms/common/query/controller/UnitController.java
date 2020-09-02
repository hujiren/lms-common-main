package com.apl.lms.common.query.controller;


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


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<CommodityUnitDto>> getUnitByPage(PageDto pageDto, @Validated CommodityUnitKeyDto keyDto) throws Exception {
        return commodityUnitService.getUnitByPage(pageDto , keyDto);
    }

}
