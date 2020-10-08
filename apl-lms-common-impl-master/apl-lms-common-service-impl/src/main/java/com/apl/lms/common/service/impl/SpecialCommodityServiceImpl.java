package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lms.common.mapper.SpecialCommodityMapper;
import com.apl.lms.common.query.manage.po.SpecialCommodityPo;
import com.apl.lms.common.service.SpecialCommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author hjr
 * @since 2020-08-08
 */
@Service
@Slf4j
public class SpecialCommodityServiceImpl extends ServiceImpl<SpecialCommodityMapper, SpecialCommodityPo> implements SpecialCommodityService {

    enum SpecialCommodityServiceEnum {

        ID_IS_NOT_EXISTS("ID_IS_NOT_EXISTS", "id不存在, 更新失败"),
        THE_DATA_ALREADY_EXISTS("THE_DATA_ALREADY_EXISTS", "该数据已经存在");

        private String code;
        private String msg;

        SpecialCommodityServiceEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    /**
     * 查找列表
     *
     * @return
     */
    @Override
    public List<SpecialCommodityPo> getList() {
        List<SpecialCommodityPo> specialCommodityPoList = baseMapper.getList();

        return specialCommodityPoList;
    }

    /**
     * 根据id删除特殊物品
     *
     * @param id
     * @return
     */
    @Override
    public ResultUtil<Boolean> delSpecialCommodity(Long id) {
        baseMapper.deleteById(id);
        return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS, true);
    }

    /**
     * 更新特殊物品
     *
     * @param specialCommodityPo
     * @return
     */
    @Override
    public ResultUtil<Boolean> updSpecialCommodity(SpecialCommodityPo specialCommodityPo) {
        Integer result = baseMapper.updateById(specialCommodityPo);
        if (result < 1)
            return ResultUtil.APPRESULT(SpecialCommodityServiceEnum.ID_IS_NOT_EXISTS.code, SpecialCommodityServiceEnum.ID_IS_NOT_EXISTS.msg, false);
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, true);
    }

    /**
     * 添加特殊物品
     *
     * @return
     */
    @Override
    public ResultUtil<String> addSpecialCommodity(SpecialCommodityPo specialCommodityPo) {

        List<SpecialCommodityPo> resultList = getList();

        if (null != resultList && resultList.size() > 0) {
            for (SpecialCommodityPo commodityPo : resultList) {
                if (specialCommodityPo.getCode().equals(commodityPo.getCode())) {
                    return ResultUtil.APPRESULT(SpecialCommodityServiceEnum.THE_DATA_ALREADY_EXISTS.code,
                            SpecialCommodityServiceEnum.THE_DATA_ALREADY_EXISTS.msg + ": " +specialCommodityPo.getCode().toString(), null);
                }
                if (specialCommodityPo.getSpecialCommodityName().equals(commodityPo.getSpecialCommodityName())) {
                    return ResultUtil.APPRESULT(SpecialCommodityServiceEnum.THE_DATA_ALREADY_EXISTS.code,
                            SpecialCommodityServiceEnum.THE_DATA_ALREADY_EXISTS.msg + ": " +specialCommodityPo.getSpecialCommodityName(), null);
                }
            }

        }
        specialCommodityPo.setId(SnowflakeIdWorker.generateId());
        Integer integer = baseMapper.insert(specialCommodityPo);
        if (integer < 1) {
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, null);
        }
        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, specialCommodityPo.getId().toString());
    }

}