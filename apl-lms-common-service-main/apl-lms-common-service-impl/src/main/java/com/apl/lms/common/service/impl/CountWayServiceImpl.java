package com.apl.lms.common.service.impl;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.CountWayKeyDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lms.common.mapper.CountWayMapper;
import com.apl.lms.common.service.CountWayService;

import java.util.List;


/**
 * <p>
 *  service实现类
 * </p>
 *
 * @author arran
 * @since 2020-03-30
 */
@Service
@Slf4j
public class CountWayServiceImpl extends ServiceImpl<CountWayMapper, CountWayKeyDto> implements CountWayService {

    //状态code枚举
    /*enum CountWayServiceCode {

        ;

        private String code;
        private String msg;

        CountWayServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/



    @Override
    public ResultUtils<Integer> add(CountWayKeyDto countWayKeyDto){

        Integer flag = baseMapper.insert(countWayKeyDto);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , countWayKeyDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(CountWayKeyDto countWayKeyDto){


        Integer flag = baseMapper.updateById(countWayKeyDto);
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
    public ResultUtils<CountWayKeyDto> selectById(Long id){

        CountWayKeyDto countWayKeyDto = baseMapper.getById(id);
        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, countWayKeyDto);
    }


    @Override
    public ResultUtils<List<CountWayKeyDto>> getList(){

        List<CountWayKeyDto> list = baseMapper.getList();


        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, list);
    }


}
