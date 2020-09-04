package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.AirPortAddDto;
import com.apl.lms.common.query.manage.dto.AirPortKeyDto;
import com.apl.lms.common.query.manage.vo.AirPortListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 机场 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */

public interface AirPortMapper extends BaseMapper<AirPortAddDto> {

    /**
     * @Desc: 根据code查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public AirPortAddDto selectByCode(@Param("portCode") String portCode);

    /**
     * @Desc: 根据code 删除
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    public Integer delByCode(@Param("portCode") String portCode);



    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<AirPortListVo> getList(Page page, @Param("key") AirPortKeyDto airPortKeyDto);

    List<AirPortAddDto> exists(@Param("portCode") String portCode, @Param("nameCn") String nameCn, @Param("nameEn") String nameEn );



}
