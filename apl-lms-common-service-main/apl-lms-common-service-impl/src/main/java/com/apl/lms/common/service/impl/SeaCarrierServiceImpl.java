package com.apl.lms.common.service.impl;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.SeaCarrierKeyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.apl.lms.common.mapper.SeaCarrierMapper;
import com.apl.lms.common.service.SeaCarrierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * <p>
 * 般公司 service实现类
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class SeaCarrierServiceImpl extends ServiceImpl<SeaCarrierMapper, SeaCarrierKeyDto> implements SeaCarrierService {

    //状态code枚举
    /*enum SeaCarrierServiceCode {

        ;

        private String code;
        private String msg;

        SeaCarrierServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/



    @Override
    public ResultUtils<Integer> add(SeaCarrierKeyDto seaCarrierKeyDto){


        Integer flag = baseMapper.insert(seaCarrierKeyDto);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , seaCarrierKeyDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(SeaCarrierKeyDto seaCarrierKeyDto){


        Integer flag = baseMapper.updateById(seaCarrierKeyDto);
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
    public ResultUtils<SeaCarrierKeyDto> selectById(Long id){

        SeaCarrierKeyDto seaCarrierInfoVo = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, seaCarrierInfoVo);
    }


    @Override
    public ResultUtils<Page<SeaCarrierKeyDto>> getList(PageDto pageDto, SeaCarrierKeyDto seaCarrierKeyDto){

        Page<SeaCarrierKeyDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<SeaCarrierKeyDto> list = baseMapper.getList(page , seaCarrierKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }


}
