package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtil;
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
         * @Desc: 添加
         * @author arran
         * @since 2020-03-30
         */
        ResultUtil<Integer> add(CountWayDto countWayDto);


        /**
         * @Desc: 更新
         * @author arran
         * @since 2020-03-30
         */
        ResultUtil<Boolean> updById(CountWayDto countWayDto);


        /**
         * @Desc: 删除
         * @author arran
         * @since 2020-03-30
         */
        ResultUtil<Boolean> delById(Long id);


        /**
         * @Desc: 获取详细
         * @author arran
         * @since 2020-03-30
         */
        ResultUtil<CountWayDto> selectById(Long id);


        /**
         * @Desc: 获取列表
         * @author arran
         * @since 2020-03-30
         */
        ResultUtil<List<CountWayDto>>getList();

}
