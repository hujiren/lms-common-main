package com.apl.lms.common.service.impl;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.AirPortKeyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.apl.lms.common.mapper.AirPortMapper;
import com.apl.lms.common.service.AirPortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * <p>
 * 机场 service实现类
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class AirPortServiceImpl extends ServiceImpl<AirPortMapper, AirPortKeyDto> implements AirPortService {

    //状态code枚举
    /*enum AirPortServiceCode {

        ;

        private String code;
        private String msg;

        AirPortServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/



    @Override
    public ResultUtils<Integer> add(AirPortKeyDto airPortKeyDto){


        Integer flag = baseMapper.insert(airPortKeyDto);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , airPortKeyDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(AirPortKeyDto airPortKeyDto){


        Integer flag = baseMapper.updateById(airPortKeyDto);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , false);
    }


    @Override
    public ResultUtils<Boolean> delById(Long id){

        boolean flag = removeById(id);
        if(flag){
            return ResultUtils.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.DEL_FAIL , false);
    }


    @Override
    public ResultUtils<AirPortKeyDto> selectById(Long id){

        AirPortKeyDto airPortKeyDto = baseMapper.getById(id);


        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, airPortKeyDto);
    }


    @Override
    public ResultUtils<Page<AirPortKeyDto>> getList(PageDto pageDto, AirPortKeyDto airPortKeyDto){

        Page<AirPortKeyDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<AirPortKeyDto> list = baseMapper.getList(page , airPortKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);

    }


}
