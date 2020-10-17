package com.apl.lms.common.query.controller;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.BulkyWayDto;
import com.apl.lms.common.query.manage.dto.BulkyWayKeyDto;
import com.apl.lms.common.service.BulkyWayService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjr start
 * @date 2020/8/6 - 14:09
 */
@RestController
@RequestMapping("/weight-way")
@Validated
@Api(value = "公共计泡方式",tags = "公共计泡方式")
public class WeightWayController {

    @Autowired
    BulkyWayService bulkyWayService;

    @PostMapping(value = "/get-list")
    @ApiOperation(value =  "分页获取计泡方式列表" , notes = "根据关键字来查询")
    public ResultUtil<Page<BulkyWayDto>> getList(PageDto pageDto ,
                                                 @Validated BulkyWayKeyDto bulkyWayKeyDto){
        return bulkyWayService.getList(pageDto, bulkyWayKeyDto);
    }

}
