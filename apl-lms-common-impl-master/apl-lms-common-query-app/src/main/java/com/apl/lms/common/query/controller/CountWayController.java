package com.apl.lms.common.query.controller;


import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.query.manage.dto.CountWayDto;
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
@Api(value = "计件方式",tags = "计件方式")
@Slf4j
public class CountWayController {

    @Autowired
    public CountWayService countWayService;


    @PostMapping("/get-list")
    @ApiOperation(value =  "列表")
    public ResultUtil<List<CountWayDto>> getList() {
        return countWayService.getList();
    }

}
