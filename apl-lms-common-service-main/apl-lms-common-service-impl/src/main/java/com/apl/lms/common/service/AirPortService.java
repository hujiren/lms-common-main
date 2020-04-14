package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtils;

import com.apl.lms.common.dto.AirPortKeyDto;
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
public interface AirPortService extends IService<AirPortKeyDto> {

        /**
         * @Desc: 添加一个AirPortPo实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Integer> add(AirPortKeyDto airPort);


        /**
         * @Desc: 根据id 更新一个AirPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> updById(AirPortKeyDto airPort);


        /**
         * @Desc: 根据id 查找一个AirPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> delById(Long id);


        /**
         * @Desc: 根据id 查找一个 AirPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<AirPortKeyDto> selectById(Long id);


        /**
         * @Desc: 分页查找 AirPortPo 列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Page<AirPortKeyDto>>getList(PageDto pageDto, AirPortKeyDto airPortKeyDto);

}
