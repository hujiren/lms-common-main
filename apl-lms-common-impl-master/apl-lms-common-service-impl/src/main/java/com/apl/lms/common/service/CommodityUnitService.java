package com.apl.lms.common.service;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.dto.CommodityUnitDto;
import com.apl.lms.common.query.manage.dto.CommodityUnitKeyDto;
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
         * @Desc: 添加
         * @author cy
         * @since 2019-12-19
         */
        ResultUtil<Integer> add(CommodityUnitDto commodityUnitDto) throws Exception;


        /**
         * @Desc: 更新
         * @author cy
         * @since 2019-12-19
         */
        ResultUtil<Boolean> updateUnitById(CommodityUnitDto commodityUnitDto) throws Exception;


        /**
         * @Desc: 删除
         * @author cy
         * @since 2019-12-19
         */
        ResultUtil<Boolean> deleteUnitById(Long id) throws Exception;


        /**
         * @Desc: 获取详细
         * @author cy
         * @since 2019-12-19
         */
        ResultUtil<CommodityUnitDto> selectUnitById(Long id);


        /**
         * @Desc: 分页查找列表
         * @author cy
         * @since 2019-12-19
         */
        ResultUtil<Page<CommodityUnitDto>> getUnitByPage(PageDto pageDto, CommodityUnitKeyDto keyDto) throws Exception;

}
