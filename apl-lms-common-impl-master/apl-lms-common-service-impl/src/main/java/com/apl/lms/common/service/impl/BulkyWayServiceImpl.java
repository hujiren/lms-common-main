package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lms.common.mapper.BulkyWayMapper;
import com.apl.lms.common.query.manage.dto.*;
import com.apl.lms.common.service.BulkyWayService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author hjr
 * @since 2020-08-08
 */
@Service
@Slf4j
public class BulkyWayServiceImpl extends ServiceImpl<BulkyWayMapper, BulkyWayDto> implements BulkyWayService {

    /**
     * 查找列表
     * @param bulkyWayKeyDto
     * @return
     */
    @Override
    public ResultUtil<Page<BulkyWayDto>> getList(PageDto pageDto, BulkyWayKeyDto bulkyWayKeyDto) {

        Page<BulkyWayDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());
        List<BulkyWayDto> bulkyWayDtoList = baseMapper.getList(page, bulkyWayKeyDto);

        page.setRecords(bulkyWayDtoList);
        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public ResultUtil<Boolean> delBulkyWay(Long id) {
        Integer integer = baseMapper.deleteById(id);
        return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS, true);
    }

    /**
     * 更新
     * @param bulkyWayDto
     * @return
     */
    @Override
    public ResultUtil<Boolean>  updWeightWay(BulkyWayDto bulkyWayDto) {

        Integer integer = baseMapper.updateById(bulkyWayDto);
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, false);
    }

    /**
     * 新增
     * @param bulkyWayAddDto
     * @return
     */
    @Override
    public ResultUtil<String> addBulkyWay(BulkyWayAddDto bulkyWayAddDto) {

        BulkyWayDto bulkyWayDto = new BulkyWayDto();
        BeanUtils.copyProperties(bulkyWayAddDto, bulkyWayDto);
        bulkyWayDto.setId(SnowflakeIdWorker.generateId());

        Integer integer = baseMapper.insert(bulkyWayDto);
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, bulkyWayDto.getId().toString());
    }

    /**
     * 获取详细
     * @param id
     * @return
     */
    @Override
    public ResultUtil<BulkyWayDto> getBulkyWayInfo(Long id) {
        BulkyWayDto bulkyWayDto = baseMapper.selectById(id);
        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, bulkyWayDto);
    }
}
