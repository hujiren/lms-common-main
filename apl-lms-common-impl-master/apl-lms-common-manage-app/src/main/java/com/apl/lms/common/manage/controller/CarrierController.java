package com.apl.lms.common.manage.controller;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lms.common.query.manage.po.CommonCarrierPo;
import com.apl.lms.common.service.CommonCarrierService;
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
import java.io.IOException;
import java.util.List;

/**
 *
 * @author hjr
 * @since 2020-10-07
 */
@RestController
@RequestMapping(value = "/common-carrier")
@Validated
@Api(value = "公共运输方",tags = "公共运输方")
@Slf4j
public class CarrierController {

    @Autowired
    public CommonCarrierService commonCarrierService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="添加")
    public ResultUtil<Long> add(@Validated CommonCarrierPo commonCarrierPo) throws IOException {

        ApiParamValidate.validate(commonCarrierPo);

        return commonCarrierService.add(commonCarrierPo);
    }

    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="更新")
    public ResultUtil<Boolean> updById(@Validated CommonCarrierPo commonCarrierPo) throws IOException {

        ApiParamValidate.notEmpty("id", commonCarrierPo.getId());
        ApiParamValidate.validate(commonCarrierPo);

        return commonCarrierService.updById(commonCarrierPo);
    }

    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtil<Boolean> delById(@NotNull(message = "id不能为空") @Min(value = 1 , message = "id不能小于1") Long id) throws IOException {

        return commonCarrierService.delById(id);
    }

    @PostMapping(value = "/get-list")
    @ApiOperation(value =  "查找列表" , notes = "查找列表")
    public ResultUtil<List<CommonCarrierPo>> getList() throws IOException {

        List<CommonCarrierPo> list = commonCarrierService.getList();

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, list);
    }

}
