package com.apl.lms.common.mapper;

import com.apl.lms.common.query.manage.po.CommonCarrierPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjr
 * @since 2020-10-07
 */
@Repository
public interface CommonCarrierMapper extends BaseMapper<CommonCarrierPo> {


    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-10-07
     */
    List<CommonCarrierPo> getList();


}