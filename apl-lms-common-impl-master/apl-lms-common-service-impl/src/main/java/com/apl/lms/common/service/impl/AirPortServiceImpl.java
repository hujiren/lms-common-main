package com.apl.lms.common.service.impl;
import com.apl.lib.exception.AplException;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.query.manage.dto.AirPortDto;
import com.apl.lms.common.query.manage.dto.AirPortKeyDto;
import com.apl.lms.common.query.manage.dto.AirPortUpdDto;
import com.apl.lms.common.mapper.AirPortMapper;
import com.apl.lms.common.query.manage.vo.AirPortListVo;
import com.apl.lms.common.service.AirPortService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;


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
public class AirPortServiceImpl extends ServiceImpl<AirPortMapper, AirPortDto> implements AirPortService {

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
    @Autowired
    AirPortMapper airPortMapper;

    @Override
    public ResultUtils<String> add(AirPortDto airPortDto){

        this.exists(null, airPortDto.getPortCode(),  airPortDto.getNameCn(),  airPortDto.getNameEn());
        Integer flag = baseMapper.insert(airPortDto);

        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , airPortDto.getPortCode());
        }
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);

    }

    @Override
    public ResultUtils<Boolean> updByCode(AirPortUpdDto airPortUpdDto){

        this.exists(airPortUpdDto.getOldCode(),  airPortUpdDto.getPortCode(),  airPortUpdDto.getNameCn(),  airPortUpdDto.getNameEn() );

        AirPortDto apt = new AirPortDto();
        BeanUtils.copyProperties(airPortUpdDto, apt);
        UpdateWrapper<AirPortDto> wrapper = new UpdateWrapper<>();
        wrapper.eq("port_code", airPortUpdDto.getOldCode());
        Integer flag = baseMapper.update(apt, wrapper);

        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , false);

    }

    @Override
    public ResultUtils<Boolean> delByCode(String portCode){

        Integer flag = airPortMapper.delByCode(portCode);

        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }else{
            return ResultUtils.APPRESULT(CommonStatusCode.DEL_FAIL , false);
        }
    }

    @Override
    public ResultUtils<AirPortDto> selectByCode(String portCode){

        AirPortDto airPortDto = airPortMapper.selectByCode(portCode);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, airPortDto);

    }

    @Override
    public ResultUtils<Page<AirPortListVo>> getList(PageDto pageDto, AirPortKeyDto airPortKeyDto){

        Page<AirPortListVo> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<AirPortListVo> list = airPortMapper.getList(page , airPortKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);

    }

    void exists(String oldCode, String portCode, String nameCn, String nameEn) {

        List<AirPortDto> list = airPortMapper.exists(portCode,  nameCn,  nameEn );
        if (!CollectionUtils.isEmpty(list)) {
            for(AirPortDto  airPortInfoVo : list) {

                if (oldCode == null || !airPortInfoVo.getPortCode().equals(oldCode)) {
                    if(airPortInfoVo.getPortCode().equals(portCode))
                        throw new AplException("CODE_EXIST", "code已经存在");
                    if(airPortInfoVo.getNameCn().equals(nameCn))
                        throw new AplException("NAME_CN_EXIST", "nameCn已经存在");
                    if(airPortInfoVo.getNameEn().equals(nameEn))
                        throw new AplException("NAME_EN_EXIST", "nameEn已经存在");
                }
            }
        }
    }
}