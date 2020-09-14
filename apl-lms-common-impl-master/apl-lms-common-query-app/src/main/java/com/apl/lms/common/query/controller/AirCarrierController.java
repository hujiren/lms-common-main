package com.apl.lms.common.query.controller;


import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.AirCarrierDto;
import com.apl.lms.common.query.manage.dto.AirCarrierKeyDto;
import com.apl.lms.common.service.AirCarrierService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cy
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/air-carrier")
@Validated
@Api(value = "公共航空公司",tags = "公共航空公司")
@Slf4j
public class AirCarrierController {

    @Autowired
    public AirCarrierService airCarrierService;


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<AirCarrierDto>> getList(PageDto pageDto, AirCarrierKeyDto airCarrierKeyDto) {
        return airCarrierService.getList(pageDto , airCarrierKeyDto);
    }



}
