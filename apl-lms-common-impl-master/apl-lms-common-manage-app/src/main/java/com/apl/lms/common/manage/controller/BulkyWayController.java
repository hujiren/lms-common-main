package com.apl.lms.common.manage.controller;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.*;
import com.apl.lms.common.service.BulkyWayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author hjr start
 * @date 2020/8/6 - 14:09
 */
@RestController
@RequestMapping("/bulky-way")
@Validated
@Api(value = "计泡方式",tags = "计泡方式")
public class BulkyWayController {

    @Autowired
    BulkyWayService bulkyWayService;

    @PostMapping(value = "/get-list")
    @ApiOperation(value =  "获取计泡方式列表" , notes = "根据关键字来查询")
    public ResultUtil<List<BulkyWayDto>> getList(){

        List<BulkyWayDto> bulkyWayList = bulkyWayService.getList();

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, bulkyWayList);

    }

    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "根据id删除")
    @ApiImplicitParam(name = "id", value = "计泡方式id", required = true, paramType = "query")
    public ResultUtil<Boolean> del(@NotNull(message = "id不能为空") Long id){

        return bulkyWayService.delBulkyWay(id);

    }

    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新" , notes = "根据id更新计泡方式")
    public ResultUtil<Boolean> upd( @Validated BulkyWayDto weightWayDto){

        return bulkyWayService.updWeightWay(weightWayDto);

    }

    @PostMapping(value = "/add")
    @ApiOperation(value =  "新增" , notes = "新增计泡方式")
    public ResultUtil<String> add( @Validated BulkyWayAddDto bulkyWayAddDto){

        return bulkyWayService.addBulkyWay(bulkyWayAddDto);

    }

}
