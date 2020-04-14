package com.apl.inner.sys.controller;


import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtils;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.org.sys.service.CommodityUnitService;
import com.apl.org.sys.pojo.dto.CommodityUnitKeyDto;
import com.apl.org.sys.pojo.po.CommodityUnitPo;
import com.apl.org.sys.pojo.vo.CommodityUnitVo;
import com.apl.sys.lib.constants.url.InnerUrlConstants;
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
 * @author cy
 * @since 2019-12-19
 */
@RestController
@RequestMapping(InnerUrlConstants.INNER_ROOT_PATH+"/commodity_unit")
@Validated
@Api(value = "单位管理",tags = "单位管理")
@Slf4j
public class UnitController {

    @Autowired
    public CommodityUnitService commodityUnitService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="UNIT_CODE_EXIST -> unitCode已经存在\n"+
                                         "UNIT_NAME_EXIST -> unitName已经存在")
    public ResultUtils<Long> add(CommodityUnitPo commodityUnitPo) throws Exception {
        ApiParamValidate.validate(commodityUnitPo);

        return commodityUnitService.add(commodityUnitPo);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="UNIT_CODE_EXIST -> unitCode已经存在\n"+
                                          "UNIT_NAME_EXIST -> unitName已经存在")
    public ResultUtils<Boolean> updById(CommodityUnitPo commodityUnitPo) throws Exception {
        ApiParamValidate.notEmpty("id", commodityUnitPo.getId());
        ApiParamValidate.validate(commodityUnitPo);

        return commodityUnitService.updById(commodityUnitPo);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) throws Exception {

        return commodityUnitService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtils<CommodityUnitVo> selectById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return commodityUnitService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtils<Page<CommodityUnitVo>> getList(PageDto pageDto, @Validated CommodityUnitKeyDto keyDto) throws Exception {

        return commodityUnitService.getList(pageDto , keyDto);
    }

}
