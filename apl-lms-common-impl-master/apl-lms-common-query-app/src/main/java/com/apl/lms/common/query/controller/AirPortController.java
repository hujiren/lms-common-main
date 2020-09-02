package com.apl.lms.common.query.controller;


import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.query.manage.dto.AirPortDto;
import com.apl.lms.common.query.manage.dto.AirPortKeyDto;
import com.apl.lms.common.query.manage.dto.AirPortUpdDto;
import com.apl.lms.common.query.manage.vo.AirPortListVo;
import com.apl.lms.common.service.AirPortService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
@RequestMapping("/air-port")
@Validated
@Api(value = "空运机场",tags = "空运机场")
@Slf4j
public class AirPortController {

    @Autowired
    public AirPortService airPortService;



    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<AirPortListVo>> getList(PageDto pageDto, @Validated AirPortKeyDto airPortKeyDto) {
        return airPortService.getList(pageDto , airPortKeyDto);
    }

}
