package com.apl.lms.common.service.impl;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.SeaPortKeyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.apl.lms.common.mapper.SeaPortMapper;
import com.apl.lms.common.service.SeaPortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * <p>
 * 海港 service实现类
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class SeaPortServiceImpl extends ServiceImpl<SeaPortMapper, SeaPortKeyDto> implements SeaPortService {

    //状态code枚举
    /*enum SeaPortServiceCode {

        ;

        private String code;
        private String msg;

        SeaPortServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/



    @Override
    public ResultUtils<Integer> add(SeaPortKeyDto seaPortKeyDto){


        Integer flag = baseMapper.insert(seaPortKeyDto);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , seaPortKeyDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(SeaPortKeyDto seaPortKeyDto){


        Integer flag = baseMapper.updateById(seaPortKeyDto);
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
    public ResultUtils<SeaPortKeyDto> selectById(Long id){

        SeaPortKeyDto seaPortInfoVo = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, seaPortInfoVo);
    }


    @Override
    public ResultUtils<Page<SeaPortKeyDto>> getList(PageDto pageDto, SeaPortKeyDto seaPortKeyDto){

        Page<SeaPortKeyDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<SeaPortKeyDto> list = baseMapper.getList(page , seaPortKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }


}
