package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtil;

import com.apl.lms.common.query.manage.dto.SeaCarrierDto;
import com.apl.lms.common.query.manage.dto.SeaCarrierKeyDto;
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
         * @Desc: 添加
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Integer> add(SeaCarrierDto seaCarrierDto);


        /**
         * @Desc: 更新
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> updById(SeaCarrierDto seaCarrierDto);


        /**
         * @Desc: 删除
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> delById(Long id);


        /**
         * @Desc: 获取详细
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<SeaCarrierDto> selectById(Long id);


        /**
         * @Desc: 获取列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Page<SeaCarrierDto>>getList(PageDto pageDto, SeaCarrierKeyDto seaCarrierKeyDto);

}
