package com.apl.lms.common.manage.controller;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.po.SurchargePo;
import com.apl.lms.common.service.SurchargeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author hjr start
 * @date 2020/8/6 - 14:09
 */
@RestController
@RequestMapping("/surcharge")
@Validated
@Api(value = "附加费",tags = "附加费")
public class SurchargeController {

    @Autowired
    SurchargeService surchargeService;

    @PostMapping(value = "/get-list")
    @ApiOperation(value =  "获取附加费列表" , notes = "获取附加费列表")
    public ResultUtil<List<SurchargePo>> getList(){

        return surchargeService.getList();
    }

    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "根据id删除")
    @ApiImplicitParam(name = "id", value = "附加费Id", required = true, paramType = "query")
    public ResultUtil<Boolean> del(@NotNull(message = "id不能为空") Long id){

        return surchargeService.delSurcharge(id);
    }

    @PostMapping(value = "/add-batch")
    @ApiOperation(value =  "批量新增" , notes = "批量新增附加费")
    public ResultUtil<Integer> addBatch(@RequestBody List<SurchargePo> surchargePoList){

        return surchargeService.addSurcharge(surchargePoList);
    }
}
