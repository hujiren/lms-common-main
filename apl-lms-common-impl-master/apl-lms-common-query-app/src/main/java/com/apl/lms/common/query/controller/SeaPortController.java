package com.apl.lms.common.query.controller;


import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.lms.common.query.manage.dto.SeaPortDto;
import com.apl.lms.common.query.manage.dto.SeaPortKeyDto;
import com.apl.lms.common.query.manage.vo.SeaPortListVo;
import com.apl.lms.common.service.SeaPortService;
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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cy
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/sea-port")
@Validated
@Api(value = "海运港口",tags = "海运港口")
@Slf4j
public class SeaPortController {

    @Autowired
    public SeaPortService seaPortService;


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtil<Page<SeaPortListVo>> getList(PageDto pageDto, SeaPortKeyDto seaPortKeyDto) {
        return seaPortService.getList(pageDto , seaPortKeyDto);
    }

}
