package com.apl.lms.common.mapper;


import com.apl.lms.common.dto.CommodityUnitKeyDto;
import com.apl.lms.common.po.CommodityUnitPo;
import com.apl.lms.common.vo.CommodityUnitVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品单位 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2019-12-19
 */
public interface CommodityUnitMapper extends BaseMapper<CommodityUnitPo> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2019-12-19
     */
    public CommodityUnitVo getById(@Param("id") Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2019-12-19
     */
    List<CommodityUnitVo> getList(Page page, @Param("kd") CommodityUnitKeyDto keyDto);


    /**
     * @Desc: 检测记录是否重复
     * @Author: ${cfg.author}
     * @Date: 2019-12-19
     */
    List<CommodityUnitVo> exists(@Param("id") Long id, @Param("unitCode") String unitCode, @Param("unitName") String unitName);

}
