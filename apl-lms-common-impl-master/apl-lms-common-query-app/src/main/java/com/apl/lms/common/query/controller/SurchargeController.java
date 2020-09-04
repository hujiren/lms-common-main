package com.apl.lms.common.query.controller;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.SurchargeDto;
import com.apl.lms.common.query.manage.dto.SurchargeInsertDto;
import com.apl.lms.common.query.manage.dto.SurchargeKeyDto;
import com.apl.lms.common.service.SurchargeService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    public ResultUtil<Page<SurchargeDto>> getList(PageDto pageDto ,
                                                         @Validated SurchargeKeyDto surchargeKeyDto){
        return surchargeService.getList(pageDto, surchargeKeyDto);
    }

}
