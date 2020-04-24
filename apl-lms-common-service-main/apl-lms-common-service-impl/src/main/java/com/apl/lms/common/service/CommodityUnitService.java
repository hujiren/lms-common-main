package com.apl.lms.common.service;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtils;
import com.apl.lms.common.dto.CommodityUnitDto;
import com.apl.lms.common.dto.CommodityUnitKeyDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品单位 服务类
 * </p>
 *
 * @author cy
 * @since 2019-12-10
 */
public interface CommodityUnitService extends IService<CommodityUnitDto> {

        /**
         * @Desc: 添加一个CommodityUnitPo实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Integer> add(CommodityUnitDto commodityUnitDto) throws Exception;


        /**
         * @Desc: 根据id 更新一个CommodityUnitPo 实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Boolean> updateUnitById(CommodityUnitDto commodityUnitDto) throws Exception;


        /**
         * @Desc: 根据id 查找一个CommodityUnitPo 实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Boolean> deleteUnitById(Long id) throws Exception;


        /**
         * @Desc: 根据id 查找一个 CommodityUnitPo 实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<CommodityUnitDto> selectUnitById(Long id);


        /**
         * @Desc: 分页查找 CommodityUnitPo 列表
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Page<CommodityUnitDto>> getUnitByPage(PageDto pageDto, CommodityUnitKeyDto keyDto) throws Exception;

}
