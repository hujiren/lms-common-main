package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.CountWayDto;
import com.apl.lms.common.mapper.CountWayMapper;
import com.apl.lms.common.service.CountWayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class CountWayServiceImpl extends ServiceImpl<CountWayMapper, CountWayDto> implements CountWayService {

    /**
     * 新增
     * @param countWayDto
     * @return
     */
    @Override
    public ResultUtil<Integer> add(CountWayDto countWayDto){


        Integer flag = baseMapper.insert(countWayDto);

        if(flag.equals(1)){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , countWayDto.getId());
        }

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL , null);
    }

    /**
     * 修改
     * @param countWayDto
     * @return
     */
    @Override
    public ResultUtil<Boolean> updById(CountWayDto countWayDto){


        Integer flag = baseMapper.updateById(countWayDto);
        if(flag.equals(1)){
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

        boolean flag = removeById(id);
        if(flag){
            return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }

        return ResultUtil.APPRESULT(CommonStatusCode.DEL_FAIL , false);
    }

    /**
     * 获取详细
     * @param id
     * @return
     */
    @Override
    public ResultUtil<CountWayDto> selectById(Long id){

        CountWayDto countWayDto = baseMapper.getById(id);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, countWayDto);
    }

    /**
     * 查询列表
     * @return
     */
    @Override
    public ResultUtil<List<CountWayDto>> getList(){

        List<CountWayDto> list = baseMapper.getList();


        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, list);
    }


}
