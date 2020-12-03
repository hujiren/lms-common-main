package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.AirCarrierDto;
import com.apl.lms.common.query.manage.dto.AirCarrierKeyDto;
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
public interface AirCarrierService extends IService<AirCarrierDto> {

        /**
         * @Desc: 添加航空公司
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Integer> add(AirCarrierDto airCarrierDto);


        /**
         * @Desc: 更新航空公司
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> updById(AirCarrierDto airCarrierDto);


        /**
         * @Desc: 删除航空公司
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> delById(Long id);


        /**
         * @Desc: 获取详细
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<AirCarrierDto> selectById(Long id);


        /**
         * @Desc: 分页查找 航空公司
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Page<AirCarrierDto>>getList(PageDto pageDto, AirCarrierKeyDto airCarrierKeyDto);


}
