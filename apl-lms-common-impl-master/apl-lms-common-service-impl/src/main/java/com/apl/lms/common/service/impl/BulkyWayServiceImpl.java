package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lms.common.mapper.BulkyWayMapper;
import com.apl.lms.common.query.manage.dto.*;
import com.apl.lms.common.service.BulkyWayService;
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

    enum BulkyWayCode{

        THE_DATA_IS_ALREADY_EXISTS("THE_DATA_IS_ALREADY_EXISTS", "该数据已经存在");

        private String code;
        private String msg;

        BulkyWayCode(String code, String msg){
            this.code = code;
            this.msg = msg;
        }
    }

    /**
     * 查找列表
     * @param
     * @return
     */
    @Override
    public List<BulkyWayDto> getList() {
        List<BulkyWayDto> bulkyWayDtoList = baseMapper.getList();
        return bulkyWayDtoList;
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
        if(integer > 0)
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, true);
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, false);

    }

    /**
     * 新增
     * @param bulkyWayAddDto
     * @return
     */
    @Override
    public ResultUtil<String> addBulkyWay(BulkyWayAddDto bulkyWayAddDto) {

        List<BulkyWayDto> resultList = getList();
        if(null != resultList && resultList.size() > 0){
            for (BulkyWayDto bulkyWayDto : resultList) {
                if(bulkyWayAddDto.getCode().equals(bulkyWayDto.getCode())){
                    return ResultUtil.APPRESULT(BulkyWayCode.THE_DATA_IS_ALREADY_EXISTS.code,
                            BulkyWayCode.THE_DATA_IS_ALREADY_EXISTS.msg + ": " +bulkyWayAddDto.getCode().toString(), null);
                }
                if(bulkyWayAddDto.getBulkyWayName().equals(bulkyWayDto.getBulkyWayName())){
                    return ResultUtil.APPRESULT(BulkyWayCode.THE_DATA_IS_ALREADY_EXISTS.code,
                            BulkyWayCode.THE_DATA_IS_ALREADY_EXISTS.msg + ": " +bulkyWayAddDto.getBulkyWayName(), null);
                }
            }
        }
        BulkyWayDto bulkyWayDto = new BulkyWayDto();
        BeanUtils.copyProperties(bulkyWayAddDto, bulkyWayDto);
        bulkyWayDto.setId(SnowflakeIdWorker.generateId());

        Integer integer = baseMapper.insert(bulkyWayDto);
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, bulkyWayDto.getId().toString());
    }
}
