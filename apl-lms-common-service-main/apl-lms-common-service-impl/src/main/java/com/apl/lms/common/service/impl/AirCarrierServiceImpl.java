package com.apl.lms.common.service.impl;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.AirCarrierKeyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.apl.lms.common.mapper.AirCarrierMapper;
import com.apl.lms.common.service.AirCarrierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * <p>
 * 航空公司 service实现类
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class AirCarrierServiceImpl extends ServiceImpl<AirCarrierMapper, AirCarrierKeyDto> implements AirCarrierService {

    //状态code枚举
    enum AirCarrierServiceCode {


        ;

        private String code;
        private String msg;

        AirCarrierServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }



    @Override
    public ResultUtils<Integer> add(AirCarrierKeyDto airCarrierKeyDto){


        Integer flag = baseMapper.insert(airCarrierKeyDto);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , airCarrierKeyDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(AirCarrierKeyDto airCarrier){

        Integer flag = baseMapper.updateById(airCarrier);
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
    public ResultUtils<AirCarrierKeyDto> selectById(Long id){

        AirCarrierKeyDto airCarrierInfoVo = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, airCarrierInfoVo);
    }


    @Override
    public ResultUtils<Page<AirCarrierKeyDto>> getList(PageDto pageDto, AirCarrierKeyDto airCarrierKeyDto){

        Page<AirCarrierKeyDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<AirCarrierKeyDto> list = baseMapper.getList(page , airCarrierKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }


}
