package com.apl.lms.common.query.controller;

import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.po.SurchargePo;
import com.apl.lms.common.service.SurchargeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hjr start
 * @date 2020/8/6 - 14:09
 */
@RestController
@RequestMapping("/surcharge")
@Validated
@Api(value = "公共附加费",tags = "公共附加费")
public class SurchargeController {

    @Autowired
    SurchargeService surchargeService;

    @PostMapping(value = "/get-list")
    @ApiOperation(value =  "分页获取附加费列表" , notes = "根据关键字来查询")
    public ResultUtil<List<SurchargePo>> getList(){
        return surchargeService.getList();
    }

}
