package com.apl.lms.common.service.impl;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.CountryKeyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.apl.lms.common.mapper.CountryMapper;
import com.apl.lms.common.service.CountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * <p>
 * 国家 service实现类
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class CountryServiceImpl extends ServiceImpl<CountryMapper, CountryKeyDto> implements CountryService {

    //状态code枚举
    /*enum CountryServiceCode {

        ;

        private String code;
        private String msg;

        CountryServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/



    @Override
    public ResultUtils<Integer> add(CountryKeyDto countryKeyDto){


        Integer flag = baseMapper.insert(countryKeyDto);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , countryKeyDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(CountryKeyDto countryKeyDto){


        Integer flag = baseMapper.updateById(countryKeyDto);
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
    public ResultUtils<CountryKeyDto> selectById(Long id){

        CountryKeyDto countryKeyDto = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, countryKeyDto);
    }


    @Override
    public ResultUtils<Page<CountryKeyDto>> getList(PageDto pageDto, CountryKeyDto countryKeyDto){

        Page<CountryKeyDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<CountryKeyDto> list = baseMapper.getList(page , countryKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }


}
