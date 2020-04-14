package com.apl.org.sys.service;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtils;
import com.apl.org.sys.pojo.dto.CommodityUnitKeyDto;
import com.apl.org.sys.pojo.po.CommodityUnitPo;
import com.apl.org.sys.pojo.vo.CommodityUnitVo;
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
public interface CommodityUnitService extends IService<CommodityUnitPo> {

        /**
         * @Desc: 添加一个CommodityUnitPo实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Long> add(CommodityUnitPo commodityUnit) throws Exception;


        /**
         * @Desc: 根据id 更新一个CommodityUnitPo 实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Boolean> updById(CommodityUnitPo commodityUnit) throws Exception;


        /**
         * @Desc: 根据id 查找一个CommodityUnitPo 实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Boolean> delById(Long id) throws Exception;


        /**
         * @Desc: 根据id 查找一个 CommodityUnitPo 实体
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<CommodityUnitVo> selectById(Long id);


        /**
         * @Desc: 分页查找 CommodityUnitPo 列表
         * @author cy
         * @since 2019-12-19
         */
        ResultUtils<Page<CommodityUnitVo>>getList(PageDto pageDto, CommodityUnitKeyDto keyDto) throws Exception;

}