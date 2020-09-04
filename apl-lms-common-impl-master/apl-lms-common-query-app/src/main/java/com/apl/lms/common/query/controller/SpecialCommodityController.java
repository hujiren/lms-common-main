package com.apl.lms.common.query.controller;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.SpecialCommodityDto;
import com.apl.lms.common.query.manage.dto.SpecialCommodityInsertDto;
import com.apl.lms.common.query.manage.dto.SpecialCommodityKeyDto;
import com.apl.lms.common.service.SpecialCommodityService;
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
@RequestMapping("/special-commodity")
@Validated
@Api(value = "公共特殊物品",tags = "公共特殊物品")
public class SpecialCommodityController {

    @Autowired
    SpecialCommodityService specialCommodityService;

    @PostMapping(value = "/get-list")
    @ApiOperation(value =  "分页获取特殊物品列表" , notes = "根据关键字来查询")
    public ResultUtil<Page<SpecialCommodityDto>> getList(PageDto pageDto ,
                                                         @Validated SpecialCommodityKeyDto specialCommodityKeyDto){
        return specialCommodityService.getList(pageDto, specialCommodityKeyDto);
    }

}
