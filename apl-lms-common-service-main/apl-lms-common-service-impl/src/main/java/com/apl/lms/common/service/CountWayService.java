package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtils;

import com.apl.lms.common.dto.CountWayKeyDto;
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
public interface CountWayService extends IService<CountWayKeyDto> {

        /**
         * @Desc: 添加一个CountWayPo实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<Integer> add(CountWayKeyDto countWayKeyDto);


        /**
         * @Desc: 根据id 更新一个CountWayPo 实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<Boolean> updById(CountWayKeyDto countWayKeyDto);


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
        ResultUtils<CountWayKeyDto> selectById(Long id);


        /**
         * @Desc: CountWayPo 列表
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<List<CountWayKeyDto>>getList();

}
