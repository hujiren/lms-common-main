package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.SeaCarrierDto;
import com.apl.lms.common.query.manage.dto.SeaCarrierKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 般公司 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
public interface SeaCarrierMapper extends BaseMapper<SeaCarrierDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public SeaCarrierDto getById(@Param("id" ) Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<SeaCarrierDto> getList(Page page, @Param("key" ) SeaCarrierKeyDto seaCarrierKeyDto);

    List<SeaCarrierDto> exists(@Param("id") Long id,  @Param("carrierCode") String carrierCode,   @Param("nameCn") String nameCn,   @Param("nameEn") String nameEn );

}
