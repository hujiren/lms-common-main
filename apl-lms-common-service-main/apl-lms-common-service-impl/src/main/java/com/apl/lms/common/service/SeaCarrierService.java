package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtils;

import com.apl.lms.common.dto.SeaCarrierDto;
import com.apl.lms.common.dto.SeaCarrierKeyDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 般公司 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
public interface SeaCarrierService extends IService<SeaCarrierDto> {

        /**
         * @Desc: 添加一个SeaCarrierPo实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Integer> add(SeaCarrierDto seaCarrierDto);


        /**
         * @Desc: 根据id 更新一个SeaCarrierPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> updById(SeaCarrierDto seaCarrierDto);


        /**
         * @Desc: 根据id 查找一个SeaCarrierPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Boolean> delById(Long id);


        /**
         * @Desc: 根据id 查找一个 SeaCarrierPo 实体
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<SeaCarrierDto> selectById(Long id);


        /**
         * @Desc: 分页查找 SeaCarrierPo 列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtils<Page<SeaCarrierDto>>getList(PageDto pageDto, SeaCarrierKeyDto seaCarrierKeyDto);

}
