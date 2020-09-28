package com.apl.lms.common.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.exception.AplException;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.CommodityUnitDto;
import com.apl.lms.common.query.manage.dto.CommodityUnitKeyDto;
import com.apl.lms.common.service.CommodityUnitService;
import com.apl.lms.common.mapper.CommodityUnitMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * <p>
 * 商品单位 service实现类
 * </p>
 *
 * @author cy
 * @since 2019-12-19
 */
@Service
@Slf4j
public class CommodityUnitServiceImpl extends ServiceImpl<CommodityUnitMapper, CommodityUnitDto> implements CommodityUnitService {

    /**
     * 新增
     */
    @Autowired
    CommodityUnitMapper commodityUnitMapper;
    @Override
    public ResultUtil<Integer> add(CommodityUnitDto commodityUnitDto) {


        ResultUtil<Boolean> exists = this.exists(0L, commodityUnitDto.getUnitCode(), commodityUnitDto.getUnitName());
        if(!exists.getData())
            return ResultUtil.APPRESULT(exists.getCode(), exists.getMsg(), null);

        Integer flag = commodityUnitMapper.insert(commodityUnitDto);
        if(flag.equals(1)){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, commodityUnitDto.getId());
        }

            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL , null);

    }

    /**
     * 修改
     * @param commodityUnitDto
     * @return
     * @throws Exception
     */
    @Override
    public ResultUtil<Boolean> updateUnitById(CommodityUnitDto commodityUnitDto) throws Exception {
        ResultUtil<Boolean> exists = this.exists(commodityUnitDto.getId(), commodityUnitDto.getUnitCode(), commodityUnitDto.getUnitName());
        if(!exists.getData()){
            return exists;
        }
        Integer flag = commodityUnitMapper.updateById(commodityUnitDto);

        if(flag.equals(1)){
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtil.APPRESULT("ID_IS_NOT_EXISTS","id不存在", false);
    }

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public ResultUtil<Boolean> deleteUnitById(Long id) throws Exception {

        Integer flag = commodityUnitMapper.deleteById(id);

            return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
    }

    /**
     * 获取详细
     * @param id
     * @return
     */
    @Override
    public ResultUtil<CommodityUnitDto> selectUnitById(Long id){

        CommodityUnitDto commodityUnitDto = commodityUnitMapper.selectById(id);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, commodityUnitDto);
    }

    /**
     * 查询列表
     * @param pageDto
     * @param keyDto
     * @return
     * @throws Exception
     */
    @Override
    public ResultUtil<Page<CommodityUnitDto>> getUnitByPage(PageDto pageDto, CommodityUnitKeyDto keyDto) throws Exception {

        Page<CommodityUnitDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());
        List<CommodityUnitDto> list = commodityUnitMapper.getList(page, keyDto);
        page.setRecords(list);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS , page);
    }


    ResultUtil<Boolean> exists(Long id,  String unitCode, String unitName) {

        List<CommodityUnitDto> list = baseMapper.exists(id, unitCode,  unitName );
        if (!CollectionUtils.isEmpty(list)) {
            for(CommodityUnitDto  commodityUnitDto : list) {

                if(commodityUnitDto.getUnitCode().equals(unitCode))
                    return ResultUtil.APPRESULT("UNIT_CODE_EXIST", "unitCode已经存在", false);
                if(commodityUnitDto.getUnitName().equals(unitName))
                    return ResultUtil.APPRESULT("UNIT_NAME_EXIST", "unitName已经存在", false);
            }
        }
        return ResultUtil.APPRESULT("", "", true);
    }
}