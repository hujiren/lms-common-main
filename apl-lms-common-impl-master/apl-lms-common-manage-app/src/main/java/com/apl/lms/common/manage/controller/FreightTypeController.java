package com.apl.lms.common.manage.controller;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lms.common.query.manage.po.CommonFreightTypePo;
import com.apl.lms.common.service.FreightTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author hjr
 * @since 2020-09-29
 */
@RestController
@RequestMapping(value = "/common-freight-type")
@Validated
@Api(value = "公共运输类型",tags = "公共运输类型")
@Slf4j
public class FreightTypeController {

    @Autowired
    public FreightTypeService freightTypeService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="添加")
    public ResultUtil<Long> add(@Validated CommonFreightTypePo commonFreightTypePo) {
        ApiParamValidate.validate(commonFreightTypePo);

        return freightTypeService.add(commonFreightTypePo);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="更新")
    public ResultUtil<Boolean> updById(@Validated CommonFreightTypePo commonFreightTypePo) {
        ApiParamValidate.notEmpty("id", commonFreightTypePo.getId());
        ApiParamValidate.validate(commonFreightTypePo);

        return freightTypeService.updById(commonFreightTypePo);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtil<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) {

        return freightTypeService.delById(id);
    }


    @PostMapping(value = "/get-list")
    @ApiOperation(value =  "查找列表" , notes = "查找列表")
    public ResultUtil<List<CommonFreightTypePo>> getList() {
        List<CommonFreightTypePo> list = freightTypeService.getList();
        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS,list);
    }

}
