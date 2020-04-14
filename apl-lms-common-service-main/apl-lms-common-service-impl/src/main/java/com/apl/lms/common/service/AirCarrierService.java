package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtils;

import com.apl.lms.common.dto.AirCarrierKeyDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 航空公司 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
public interface AirCarrierService extends IService<AirCarrierKeyDto> {

        /**
         * @Desc: 添加一个AirCarrierPo实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Integer> add(AirCarrierKeyDto airCarrierKeyDto);


        /**
         * @Desc: 根据id 更新一个AirCarrierPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> updById(AirCarrierKeyDto airCarrierKeyDto);


        /**
         * @Desc: 根据id 查找一个AirCarrierPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> delById(Long id);


        /**
         * @Desc: 根据id 查找一个 AirCarrierPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<AirCarrierKeyDto> selectById(Long id);


        /**
         * @Desc: 分页查找 AirCarrierPo 列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Page<AirCarrierKeyDto>>getList(PageDto pageDto, AirCarrierKeyDto airCarrierKeyDto);

}
