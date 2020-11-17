package com.apl.lms.common.service.impl;

import com.apl.cache.AplCacheHelper;
import com.apl.cache.AplCacheUtil;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lms.common.mapper.CommonCarrierMapper;
import com.apl.lms.common.service.CommonCarrierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lms.common.query.manage.po.CommonCarrierPo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * service实现类
 * </p>
 *
 * @author hjr
 * @since 2020-10-07
 */
@Service
@Slf4j
public class CommonCarrierServiceImpl extends ServiceImpl<CommonCarrierMapper, CommonCarrierPo> implements CommonCarrierService {

    //状态code枚举
    enum CommonCarrierServiceCode {

            NO_CORRESPONDING_DATA("NO_CORRESPONDING_DATA", "没有对应数据");

            private String code;
            private String msg;

            CommonCarrierServiceCode(String code, String msg) {
                 this.code = code;
                 this.msg = msg;
            }
        }
    @Autowired
    AplCacheUtil aplCacheUtil;


    private static final String CACHE_KEY = "carrier";

    @Override
    public ResultUtil<Long> add(CommonCarrierPo commonCarrierPo) throws IOException {

        commonCarrierPo.setId(SnowflakeIdWorker.generateId());
        Integer flag = baseMapper.insert(commonCarrierPo);
        if (flag > 0) {
            updCache();
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, commonCarrierPo.getId());
        }

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, null);
    }


    @Override
    public ResultUtil<Boolean> updById(CommonCarrierPo commonCarrierPo) throws IOException {

        Integer flag = baseMapper.updateById(commonCarrierPo);
        if (flag > 0) {
            updCache();
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, true);
        }

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, false);
    }


    @Override
    public ResultUtil<Boolean> delById(Long id) throws IOException {

        Integer result = baseMapper.deleteById(id);
        if (result > 0) {
            updCache();
            return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS, true);
        }
        return ResultUtil.APPRESULT(CommonCarrierServiceCode.NO_CORRESPONDING_DATA.code,
                CommonCarrierServiceCode.NO_CORRESPONDING_DATA.msg, false);
    }


    @Override
    public List<CommonCarrierPo> getList() throws IOException {
        Boolean hasKey = aplCacheUtil.hasKey(CACHE_KEY);
        if (!hasKey) {
            List<CommonCarrierPo> carrierCacheList = updCache();
            return carrierCacheList;
        }
        List<CommonCarrierPo> carrierCacheList = (List<CommonCarrierPo>) aplCacheUtil.opsForValue().get(CACHE_KEY);
        return carrierCacheList;
    }

    /**
     * 更新缓存
     * @return
     */
    public List<CommonCarrierPo> updCache() throws IOException {

        List<CommonCarrierPo> carrierList = baseMapper.getList();
        Map<String, List<CommonCarrierPo>> carrierCacheMap = new HashMap<>();
        carrierCacheMap.put(CACHE_KEY, carrierList);
        aplCacheUtil.opsForValue().set(carrierCacheMap);
        return carrierList;
    }
}