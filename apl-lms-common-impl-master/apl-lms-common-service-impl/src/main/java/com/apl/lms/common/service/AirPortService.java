package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtils;

import com.apl.lms.common.query.manage.dto.AirPortDto;
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
public interface AirPortService extends IService<AirPortDto> {

        /**
         * @Desc: 添加一个AirPortPo实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<String> add(AirPortDto airPortDto);

        /**
         * @Desc: 更新
         * @author cy
         * @since 2020-04-13
         */
        public ResultUtils<Boolean> updByCode(AirPortUpdDto airPortUpdDto);

        /**
         * @Desc: 根据id 查找一个AirPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> delByCode(String portCode);

        /**
         * @Desc: 根据id 查找一个 AirPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<AirPortDto> selectByCode(String portCode);

        /**
         * @Desc: 分页查找 AirPortPo 列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Page<AirPortListVo>>getList(PageDto pageDto, AirPortKeyDto airPortKeyDto);

}
