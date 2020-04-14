package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.CountWayDto;
import com.apl.lms.common.po.CountWayPo;
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
public interface CountWayService extends IService<CountWayPo> {

        /**
         * @Desc: 添加一个CountWayPo实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<Integer> add(CountWayPo countWayPo);


        /**
         * @Desc: 根据id 更新一个CountWayPo 实体
         * @author arran
         * @since 2020-03-30
         */
        ResultUtils<Boolean> updById(CountWayPo countWayPo);


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
