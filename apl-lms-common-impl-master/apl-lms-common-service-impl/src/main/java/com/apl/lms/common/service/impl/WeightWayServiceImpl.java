package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lms.common.mapper.WeightWayMapper;
import com.apl.lms.common.query.manage.dto.*;
import com.apl.lms.common.service.WeightWayService;
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
public class WeightWayServiceImpl extends ServiceImpl<WeightWayMapper, WeightWayDto> implements WeightWayService {

    /**
     * 分页查找附加费
     * @param weightWayKeyDto
     * @return
     */
    @Override
    public ResultUtil<Page<WeightWayDto>> getList(PageDto pageDto, WeightWayKeyDto weightWayKeyDto) {

        Page<WeightWayDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());
        if(null == weightWayKeyDto.getCode() || weightWayKeyDto.getCode() < 0){
            weightWayKeyDto.setCode(0);
        }
        List<WeightWayDto> weightWayDtoList = baseMapper.getList(page, weightWayKeyDto);

        page.setRecords(weightWayDtoList);
        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }

    /**
     * 根据id删除附加费
     * @param id
     * @return
     */
    @Override
    public ResultUtil<Boolean> delWeightWay(Long id) {
        Integer integer = baseMapper.deleteById(id);
        if(integer < 1){
            return ResultUtil.APPRESULT(CommonStatusCode.DEL_FAIL, false);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS, true);
    }

    /**
     * 更新附加费
     * @param weightWayDto
     * @return
     */
    @Override
    public ResultUtil<Boolean>  updWeightWay(WeightWayDto weightWayDto) {

        Integer integer = baseMapper.updateById(weightWayDto);
        if(integer < 1){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, false);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, true);
    }

    /**
     * 添加附加费
     * @param weightWayAddDto
     * @return
     */
    @Override
    public ResultUtil<String> addWeightWay(WeightWayAddDto weightWayAddDto) {

        WeightWayDto weightWayDto = new WeightWayDto();
        BeanUtils.copyProperties(weightWayAddDto, weightWayDto);
        weightWayDto.setId(SnowflakeIdWorker.generateId());

        Integer integer = baseMapper.insert(weightWayDto);
        if(integer < 1){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, null);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, weightWayDto.getId().toString());
    }

    /**
     * 获取详细
     * @param id
     * @return
     */
    @Override
    public ResultUtil<WeightWayDto> getWeightWayInfo(Long id) {
        WeightWayDto weightWayDto = baseMapper.selectById(id);
        if(weightWayDto == null){
            return ResultUtil.APPRESULT(CommonStatusCode.GET_FAIL, null);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, weightWayDto);
    }
}
