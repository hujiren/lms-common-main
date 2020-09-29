package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.po.CommonFreightTypePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hjr
 * @since 2020-09-29
 */
@Repository
public interface CommonFreightTypeMapper extends BaseMapper<CommonFreightTypePo> {


    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-09-29
     */
    List<CommonFreightTypePo> getList();


}