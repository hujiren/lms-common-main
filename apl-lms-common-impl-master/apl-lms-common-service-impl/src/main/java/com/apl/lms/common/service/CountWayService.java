package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.query.manage.dto.CountWayDto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  service接口
 * </p>
 *
 * @author arran
 * @since 2020-03-30
 */
public interface CountWayService extends IService<CountWayDto> {

        /**
         * @Desc: 添加一个CountWayPo实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<Integer> add(CountWayDto countWayDto);


        /**
         * @Desc: 根据id 更新一个CountWayPo 实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<Boolean> updById(CountWayDto countWayDto);


        /**
         * @Desc: 根据id 查找一个CountWayPo 实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<Boolean> delById(Long id);


        /**
         * @Desc: 根据id 查找一个 CountWayPo 实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<CountWayDto> selectById(Long id);


        /**
         * @Desc: CountWayPo 列表
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<List<CountWayDto>>getList();

}