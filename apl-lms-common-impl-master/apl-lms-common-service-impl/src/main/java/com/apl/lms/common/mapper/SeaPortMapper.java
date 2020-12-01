package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.dto.SeaPortDto;
import com.apl.lms.common.query.manage.dto.SeaPortKeyDto;
import com.apl.lms.common.query.manage.vo.SeaPortListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 海港 Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-04-13
 */
public interface SeaPortMapper extends BaseMapper<SeaPortDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    SeaPortDto getById(@Param("id" ) Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-04-13
     */
    List<SeaPortListVo> getList(Page page, @Param("key" ) SeaPortKeyDto seaPortKeyDto);

    /**
     * 校验是否存在
     * @param id
     * @param portCode
     * @param nameCn
     * @param nameEn
     * @return
     */
    List<SeaPortDto> exists(@Param("id") Long id,  @Param("portCode") String portCode,   @Param("nameCn") String nameCn,   @Param("nameEn") String nameEn );
}
