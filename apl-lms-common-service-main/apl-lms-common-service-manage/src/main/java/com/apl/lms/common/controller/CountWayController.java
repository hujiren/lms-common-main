package com.apl.lms.common.controller;


import com.apl.lib.utils.ResultUtils;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.dto.CountWayDto;
import com.apl.lms.common.po.CountWayPo;
import com.apl.lms.common.service.CountWayService;
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
import java.util.List;

/**
 *
 * @author arran
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/count-way")
@Validated
@Api(value = "",tags = "")
@Slf4j
public class CountWayController {

    @Autowired
    public CountWayService countWayService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="")
    public ResultUtils<Integer> add(CountWayPo countWayPo) {
        ApiParamValidate.validate(countWayPo);

        return countWayService.add(countWayPo);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="")
    public ResultUtils<Boolean> updById(CountWayPo countWayPo) {
        ApiParamValidate.notEmpty("id", countWayPo.getId());
        ApiParamValidate.validate(countWayPo);

        return countWayService.updById(countWayPo);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return countWayService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtils<CountWayDto> selectById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return countWayService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "列表")
    public ResultUtils<List<CountWayDto>> getList() {

        return countWayService.getList();
    }

}
