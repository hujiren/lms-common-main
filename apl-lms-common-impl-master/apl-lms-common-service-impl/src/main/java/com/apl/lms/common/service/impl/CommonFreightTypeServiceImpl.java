package com.apl.lms.common.service.impl;

import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.mapper.CommonFreightTypeMapper;
import com.apl.lms.common.query.manage.po.CommonFreightTypePo;
import com.apl.lms.common.service.CommonFreightTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import java.util.List;


/**
 * <p>
 *  service实现类
 * </p>
 *
 * @author hjr
 * @since 2020-09-29
 */
@Service
@Slf4j
public class CommonFreightTypeServiceImpl extends ServiceImpl<CommonFreightTypeMapper, CommonFreightTypePo> implements CommonFreightTypeService {

    //状态code枚举
    /*enum CommonFreightTypeServiceCode {

            ;

            private String code;
            private String msg;

            CommonFreightTypeServiceCode(String code, String msg) {
                 this.code = code;
                 this.msg = msg;
            }
        }*/


    @Override
    public ResultUtil<Long> add(CommonFreightTypePo commonFreightTypePo){


        Integer flag = baseMapper.insert(commonFreightTypePo);
        if(flag.equals(1)){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , commonFreightTypePo.getId());
        }

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }


    @Override
    public ResultUtil<Boolean> updById(CommonFreightTypePo commonFreightTypePo){


        Integer flag = baseMapper.updateById(commonFreightTypePo);
        if(flag.equals(1)){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL , false);
    }


    @Override
    public ResultUtil<Boolean> delById(Long id){

        Integer flag = baseMapper.deleteById(id);
        if(flag > 0){
            return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }

        return ResultUtil.APPRESULT(CommonStatusCode.DEL_FAIL , false);
    }


    @Override
    public ResultUtil<List<CommonFreightTypePo>> getList(){

        List<CommonFreightTypePo> list = baseMapper.getList();

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS , list);
    }


}