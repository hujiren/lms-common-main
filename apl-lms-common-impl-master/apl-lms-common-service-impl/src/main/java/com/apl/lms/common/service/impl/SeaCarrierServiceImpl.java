package com.apl.lms.common.service.impl;
import com.apl.lib.exception.AplException;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.SeaCarrierDto;
import com.apl.lms.common.query.manage.dto.SeaCarrierKeyDto;
import com.apl.lms.common.mapper.SeaCarrierMapper;
import com.apl.lms.common.service.SeaCarrierService;
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
 * 般公司 service实现类
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class SeaCarrierServiceImpl extends ServiceImpl<SeaCarrierMapper, SeaCarrierDto> implements SeaCarrierService {

    /**
     * 新增
     * @param seaCarrierDto
     * @return
     */
    @Override
    public ResultUtil<Integer> add(SeaCarrierDto seaCarrierDto){

        this.exists(0L, seaCarrierDto.getCarrierCode(),  seaCarrierDto.getNameCn(),  seaCarrierDto.getNameEn() );
        baseMapper.insert(seaCarrierDto);

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , seaCarrierDto.getId());
    }

    /**
     * 修改
     * @param seaCarrierDto
     * @return
     */
    @Override
    public ResultUtil<Boolean> updById(SeaCarrierDto seaCarrierDto){

        this.exists(seaCarrierDto.getId(), seaCarrierDto.getCarrierCode(),  seaCarrierDto.getNameCn(),  seaCarrierDto.getNameEn() );
        baseMapper.updateById(seaCarrierDto);

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public ResultUtil<Boolean> delById(Long id){

        removeById(id);

        return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
    }

    /**
     * 获取详细
     * @param id
     * @return
     */
    @Override
    public ResultUtil<SeaCarrierDto> selectById(Long id){

        SeaCarrierDto seaCarrierDto = baseMapper.getById(id);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, seaCarrierDto);
    }

    /**
     * 查询列表
     * @param pageDto
     * @param seaCarrierKeyDto
     * @return
     */
    @Override
    public ResultUtil<Page<SeaCarrierDto>> getList(PageDto pageDto, SeaCarrierKeyDto seaCarrierKeyDto){

        Page<SeaCarrierDto> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<SeaCarrierDto> seaCarrierList = baseMapper.getList(page , seaCarrierKeyDto);
        page.setRecords(seaCarrierList);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }

    void exists(Long id,  String carrierCode,   String nameCn,   String nameEn ) {

        List<SeaCarrierDto> seaCarrierList = baseMapper.exists(id, carrierCode, nameCn, nameEn);
        if (!CollectionUtils.isEmpty(seaCarrierList)) {
            for(SeaCarrierDto  seaCarrierDto : seaCarrierList) {

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
