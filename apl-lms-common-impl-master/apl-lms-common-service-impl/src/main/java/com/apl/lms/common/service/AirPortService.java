package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtil;

import com.apl.lms.common.query.manage.dto.AirPortAddDto;
import com.apl.lms.common.query.manage.dto.AirPortKeyDto;
import com.apl.lms.common.query.manage.dto.AirPortUpdDto;
import com.apl.lms.common.query.manage.vo.AirPortListVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 机场 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
public interface AirPortService extends IService<AirPortAddDto> {

        /**
         * @Desc: 添加
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<String> add(AirPortAddDto airPortAddDto);

        /**
         * @Desc: 更新
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> updByCode(AirPortUpdDto airPortUpdDto);

        /**
         * @Desc: 删除
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> delByCode(String portCode);

        /**
         * @Desc: 获取详细
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<AirPortAddDto> selectByCode(String portCode);

        /**
         * @Desc: 分页查找列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Page<AirPortListVo>>getList(PageDto pageDto, AirPortKeyDto airPortKeyDto);

}
