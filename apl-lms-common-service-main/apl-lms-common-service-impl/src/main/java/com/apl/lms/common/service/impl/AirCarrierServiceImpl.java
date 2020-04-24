package com.apl.lms.common.service.impl;
import com.apl.lib.exception.AplException;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.AirCarrierDto;
import com.apl.lms.common.dto.AirCarrierKeyDto;
import com.apl.lms.common.dto.CountryDto;
import com.apl.lms.common.dto.CountryKeyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.apl.lms.common.mapper.AirCarrierMapper;
import com.apl.lms.common.service.AirCarrierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;


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
public class AirCarrierServiceImpl extends ServiceImpl<AirCarrierMapper, AirCarrierDto> implements AirCarrierService {

    //状态code枚举
//    enum AirCarrierServiceCode {
//
//
//        ;
//
//        private String code;
//        private String msg;
//
//        AirCarrierServiceCode(String code, String msg) {
//             this.code = code;
//             this.msg = msg;
//        }
//    }


    /**
     * 添加
     * @param airCarrierDto
     * @return
     */
    @Override
    public ResultUtils<Integer> add(AirCarrierDto airCarrierDto){

        this.exists(0L, airCarrierDto.getCarrierCode(),  airCarrierDto.getNameCn(),  airCarrierDto.getNameEn() );
        Integer flag = baseMapper.insert(airCarrierDto);
        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , airCarrierDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }

    /**
     * 根据Id更新
     * @param airCarrierDto
     * @return
     */
    @Override
    public ResultUtils<Boolean> updById(AirCarrierDto airCarrierDto){

        this.exists(airCarrierDto.getId(), airCarrierDto.getCarrierCode(),  airCarrierDto.getNameCn(),  airCarrierDto.getNameEn() );
        Integer flag = baseMapper.updateById(airCarrierDto);
        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , false);
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @Override
    public ResultUtils<Boolean> delById(Long id){

        boolean flag = removeById(id);
        if(flag){
            return ResultUtils.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.DEL_FAIL , false);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public ResultUtils<AirCarrierDto> selectById(Long id){

        AirCarrierDto airCarrierDto = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, airCarrierDto);
    }

    /**
     *
     * @param pageDto
     * @param airCarrierKeyDto
     * @return 分页查询
     */
    @Override
    public ResultUtils<Page<AirCarrierDto>> getList(PageDto pageDto, AirCarrierKeyDto airCarrierKeyDto){

        Page<AirCarrierDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<AirCarrierDto> list = baseMapper.getList(page , airCarrierKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }

    void exists(Long id, String carrierCode, String nameCn, String nameEn) {

        List<AirCarrierDto> list = baseMapper.exists(id, carrierCode,  nameCn,  nameEn );
        if (!CollectionUtils.isEmpty(list)) {
            for(AirCarrierDto  airCarrierDto : list) {

                if(airCarrierDto.getCarrierCode().equals(carrierCode))
                    throw new AplException("CODE_EXIST", "code已经存在");
                if(airCarrierDto.getNameCn().equals(nameCn))
                    throw new AplException("NAME_CN_EXIST", "nameCn已经存在");
                if(airCarrierDto.getNameEn().equals(nameEn))
                    throw new AplException("NAME_EN_EXIST", "nameEn已经存在");
            }
        }
    }

}
