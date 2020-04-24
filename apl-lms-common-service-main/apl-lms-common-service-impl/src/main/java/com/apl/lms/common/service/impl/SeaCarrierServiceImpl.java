package com.apl.lms.common.service.impl;
import com.apl.lib.exception.AplException;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.SeaCarrierDto;
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
import org.springframework.util.CollectionUtils;


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
public class SeaCarrierServiceImpl extends ServiceImpl<SeaCarrierMapper, SeaCarrierDto> implements SeaCarrierService {

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
    public ResultUtils<Integer> add(SeaCarrierDto seaCarrierDto){

        this.exists(0L, seaCarrierDto.getCarrierCode(),  seaCarrierDto.getNameCn(),  seaCarrierDto.getNameEn() );
        Integer flag = baseMapper.insert(seaCarrierDto);
        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , seaCarrierDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(SeaCarrierDto seaCarrierDto){

        this.exists(seaCarrierDto.getId(), seaCarrierDto.getCarrierCode(),  seaCarrierDto.getNameCn(),  seaCarrierDto.getNameEn() );
        Integer flag = baseMapper.updateById(seaCarrierDto);
        if(flag > 0){
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
    public ResultUtils<SeaCarrierDto> selectById(Long id){

        SeaCarrierDto seaCarrierDto = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, seaCarrierDto);
    }


    @Override
    public ResultUtils<Page<SeaCarrierDto>> getList(PageDto pageDto, SeaCarrierKeyDto seaCarrierKeyDto){

        Page<SeaCarrierDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<SeaCarrierDto> list = baseMapper.getList(page , seaCarrierKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }

    void exists(Long id,  String carrierCode,   String nameCn,   String nameEn ) {

        List<SeaCarrierDto> list = baseMapper.exists(id, carrierCode, nameCn, nameEn);
        if (!CollectionUtils.isEmpty(list)) {
            for(SeaCarrierDto  seaCarrierDto : list) {

                if(seaCarrierDto.getCarrierCode().equals(carrierCode))
                    throw new AplException("CODE_EXIST", "code已经存在");
                if(seaCarrierDto.getNameCn().equals(nameCn))
                    throw new AplException("NAME_CN_EXIST", "nameCn已经存在");
                if(seaCarrierDto.getNameEn().equals(nameEn))
                    throw new AplException("NAME_EN_EXIST", "nameEn已经存在");
            }
        }
    }
}
