package com.apl.lms.common.mapper;


import com.apl.lms.common.query.manage.dto.CommodityUnitDto;
import com.apl.lms.common.query.manage.dto.CommodityUnitKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品单位 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2019-12-19
 */
@Repository
public interface CommodityUnitMapper extends BaseMapper<CommodityUnitDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2019-12-19
     */
    public CommodityUnitDto getById(@Param("id") Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2019-12-19
     */
    List<CommodityUnitDto> getList(Page page, @Param("key") CommodityUnitKeyDto keyDto);


    /**
     * @Desc: 检测记录是否重复
     * @Author: ${cfg.author}
     * @Date: 2019-12-19
     */
    List<CommodityUnitDto> exists(@Param("id") Long id,  @Param("unitCode") String unitCode,  @Param("unitName") String unitName);

}
