package com.apl.lms.common.service;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 航空公司 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-08-08
 */
public interface BulkyWayService extends IService<BulkyWayDto> {

    /**
     * @Desc: 分页查找 计泡方式列表
     * @author hjr
     * @since 2020-08-08
     */
    ResultUtil<Page<BulkyWayDto>> getList(PageDto pageDto, BulkyWayKeyDto bulkyWayKeyDto);

    /**
     * @Desc: 根据Id删除计泡方式
     * @author hjr
     * @since 2020-08-08
     */
    ResultUtil<Boolean> delBulkyWay(Long id);

    /**
     * @Desc: 更新计泡方式
     * @author hjr
     * @since 2020-08-08
     */
    ResultUtil<Boolean> updWeightWay(BulkyWayDto bulkyWayDto);

    /**
     * @Desc: 新增计泡方式
     * @author hjr
     * @since 2020-08-08
     */
    ResultUtil<String> addBulkyWay(BulkyWayAddDto bulkyWayAddDto);

        /**
         * 获取详情
         * @param id
         * @return
         */
    ResultUtil<BulkyWayDto> getBulkyWayInfo(Long id);
}
