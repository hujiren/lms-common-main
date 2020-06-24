package com.apl.lms.common.service.impl;
import com.apl.lib.exception.AplException;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.query.manage.dto.SeaPortDto;
import com.apl.lms.common.query.manage.dto.SeaPortKeyDto;
import com.apl.lms.common.mapper.SeaPortMapper;
import com.apl.lms.common.query.manage.vo.SeaPortListVo;
import com.apl.lms.common.service.SeaPortService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;


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
public class SeaPortServiceImpl extends ServiceImpl<SeaPortMapper, SeaPortDto> implements SeaPortService {

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
    public ResultUtils<Integer> add(SeaPortDto seaPortDto){

        this.exists(0L, seaPortDto.getPortCode(),  seaPortDto.getNameCn(),  seaPortDto.getNameEn() );
        Integer flag = baseMapper.insert(seaPortDto);
        if(flag > 0){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , seaPortDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtils<Boolean> updById(SeaPortDto seaPortDto){

        this.exists(seaPortDto.getId(), seaPortDto.getPortCode(),  seaPortDto.getNameCn(),  seaPortDto.getNameEn() );
        Integer flag = baseMapper.updateById(seaPortDto);
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
    public ResultUtils<SeaPortDto> selectById(Long id){

        SeaPortDto seaPortDto = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, seaPortDto);
    }


    @Override
    public ResultUtils<Page<SeaPortListVo>> getList(PageDto pageDto, SeaPortKeyDto seaPortKeyDto){

        Page<SeaPortListVo> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<SeaPortListVo> list = baseMapper.getList(page , seaPortKeyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }

    void exists(Long id,  String portCode,   String nameCn,   String nameEn ) {

        List<SeaPortDto> list = baseMapper.exists(id, portCode,  nameCn,  nameEn);
        if (!CollectionUtils.isEmpty(list)) {
            for(SeaPortDto  seaPortInfoVo : list) {

                if(seaPortInfoVo.getPortCode().equals(portCode))
                    throw new AplException("CODE_EXIST", "code已经存在");
                if(seaPortInfoVo.getNameCn().equals(nameCn))
                    throw new AplException("NAME_CN_EXIST", "nameCn已经存在");
                if(seaPortInfoVo.getNameEn().equals(nameEn))
                    throw new AplException("NAME_EN_EXIST", "nameEn已经存在");
            }
        }
    }
}
