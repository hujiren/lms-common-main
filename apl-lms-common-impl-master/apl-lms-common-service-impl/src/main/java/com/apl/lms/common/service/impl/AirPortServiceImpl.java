package com.apl.lms.common.service.impl;
import com.apl.lib.exception.AplException;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.AirPortAddDto;
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
public class AirPortServiceImpl extends ServiceImpl<AirPortMapper, AirPortAddDto> implements AirPortService {

    @Autowired
    AirPortMapper airPortMapper;

    /**
     * 添加
     * @param airPortAddDto
     * @return
     */
    @Override
    public ResultUtil<String> add(AirPortAddDto airPortAddDto){

        this.exists(null, airPortAddDto.getPortCode(),  airPortAddDto.getNameCn(),  airPortAddDto.getNameEn());
        baseMapper.insert(airPortAddDto);

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , airPortAddDto.getPortCode());

    }

    /**
     * 更新
     * @param airPortUpdDto
     * @return
     */
    @Override
    public ResultUtil<Boolean> updByCode(AirPortUpdDto airPortUpdDto){

        this.exists(airPortUpdDto.getOldCode(),  airPortUpdDto.getPortCode(),  airPortUpdDto.getNameCn(),  airPortUpdDto.getNameEn() );

        AirPortAddDto airPortDto = new AirPortAddDto();
        BeanUtils.copyProperties(airPortUpdDto, airPortDto);
        UpdateWrapper<AirPortAddDto> wrapper = new UpdateWrapper<>();
        wrapper.eq("port_code", airPortUpdDto.getOldCode());
        baseMapper.update(airPortDto, wrapper);

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);

    }

    /**
     * 删除
     * @param portCode
     * @return
     */
    @Override
    public ResultUtil<Boolean> delByCode(String portCode){

        airPortMapper.delByCode(portCode);

        return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
    }

    /**
     * 获取详细
     * @param portCode
     * @return
     */
    @Override
    public ResultUtil<AirPortAddDto> selectByCode(String portCode){

        AirPortAddDto airPortAddDto = airPortMapper.selectByCode(portCode);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, airPortAddDto);

    }

    /**
     * 分页查找列表
     * @param pageDto
     * @param airPortKeyDto
     * @return
     */
    @Override
    public ResultUtil<Page<AirPortListVo>> getList(PageDto pageDto, AirPortKeyDto airPortKeyDto){

        Page<AirPortListVo> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<AirPortListVo> list = airPortMapper.getList(page , airPortKeyDto);
        page.setRecords(list);

        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, page);

    }

    void exists(String oldCode, String portCode, String nameCn, String nameEn) {

        List<AirPortAddDto> list = airPortMapper.exists(portCode,  nameCn,  nameEn );
        if (!CollectionUtils.isEmpty(list)) {
            for(AirPortAddDto airPortInfoVo : list) {

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
