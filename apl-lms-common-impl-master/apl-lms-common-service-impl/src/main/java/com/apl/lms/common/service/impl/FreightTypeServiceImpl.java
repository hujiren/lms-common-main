package com.apl.lms.common.service.impl;

import com.apl.lib.utils.ResultUtil;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lms.common.mapper.FreightTypeMapper;
import com.apl.lms.common.query.manage.po.CommonFreightTypePo;
import com.apl.lms.common.service.FreightTypeService;
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
public class FreightTypeServiceImpl extends ServiceImpl<FreightTypeMapper, CommonFreightTypePo> implements FreightTypeService {

    //状态code枚举
    enum CommonFreightTypeServiceCode {

        DATA_CANNOT_BE_ADDED_REPEATEDLY("DATA_CANNOT_BE_ADDED_REPEATEDLY", "该数据已经存在");

            private String code;
            private String msg;

            CommonFreightTypeServiceCode(String code, String msg) {
                 this.code = code;
                 this.msg = msg;
            }
        }

    /**
     * 添加
     * @param commonFreightTypePo
     * @return
     */
    @Override
    public ResultUtil<Long> add(CommonFreightTypePo commonFreightTypePo){

        List<CommonFreightTypePo> resultList = getList();

            if(null != resultList && resultList.size() > 0){
                for (CommonFreightTypePo freightTypePo : resultList) {
                    if(freightTypePo.getFreightTypeName().equals(commonFreightTypePo.getFreightTypeName())){
                        return ResultUtil.APPRESULT(CommonFreightTypeServiceCode.DATA_CANNOT_BE_ADDED_REPEATEDLY.code,
                                CommonFreightTypeServiceCode.DATA_CANNOT_BE_ADDED_REPEATEDLY.msg + " " +freightTypePo.getFreightTypeName(), null);
                    }
                    if(freightTypePo.getCode().equals(commonFreightTypePo.getCode())){
                        return ResultUtil.APPRESULT(CommonFreightTypeServiceCode.DATA_CANNOT_BE_ADDED_REPEATEDLY.code,
                                CommonFreightTypeServiceCode.DATA_CANNOT_BE_ADDED_REPEATEDLY.msg + " " +freightTypePo.getCode().toString(), null);
                    }
                }

            }

        Long snowId = SnowflakeIdWorker.generateId();
        commonFreightTypePo.setId(snowId);
        Integer resultNum = baseMapper.insert(commonFreightTypePo);
        if(resultNum.equals(1)){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , commonFreightTypePo.getId());
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }

    /**
     * 修改
     * @param commonFreightTypePo
     * @return
     */
    @Override
    public ResultUtil<Boolean> updById(CommonFreightTypePo commonFreightTypePo){


        Integer resultNum = baseMapper.updateById(commonFreightTypePo);
        if(resultNum.equals(1)){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL , false);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public ResultUtil<Boolean> delById(Long id){

        Integer resultNum = baseMapper.deleteById(id);
            return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);

    }

    /**
     * 获取列表
     * @return
     */
    @Override
    public List<CommonFreightTypePo> getList(){

        List<CommonFreightTypePo> list = baseMapper.getList();
        return list;
    }


}