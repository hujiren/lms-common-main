package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtils;

import com.apl.lms.common.dto.SeaPortKeyDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 海港 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
public interface SeaPortService extends IService<SeaPortKeyDto> {

        /**
         * @Desc: 添加一个SeaPortPo实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Integer> add(SeaPortKeyDto seaPortKeyDto);


        /**
         * @Desc: 根据id 更新一个SeaPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> updById(SeaPortKeyDto seaPortKeyDto);


        /**
         * @Desc: 根据id 查找一个SeaPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> delById(Long id);


        /**
         * @Desc: 根据id 查找一个 SeaPortPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<SeaPortKeyDto> selectById(Long id);


        /**
         * @Desc: 分页查找 SeaPortPo 列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Page<SeaPortKeyDto>>getList(PageDto pageDto, SeaPortKeyDto seaPortKeyDto);

}
