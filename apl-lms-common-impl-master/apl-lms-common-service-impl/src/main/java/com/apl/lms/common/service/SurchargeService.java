package com.apl.lms.common.service;

import com.apl.lib.utils.ResultUtil;
import com.apl.lms.common.query.manage.po.SurchargePo;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
 * <p>
 * 航空公司 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-08-08
 */
public interface SurchargeService extends IService<SurchargePo> {

    /**
     * @Desc: 附加费列表
     * @author hjr
     * @since 2020-08-08
     */
    ResultUtil<List<SurchargePo>> getList();

    /**
     * @Desc: 根据Id删除附加费
     * @author hjr
     * @since 2020-08-08
     */
    ResultUtil<Boolean> delSurcharge(Long id);

    /**
     * @Desc: 批量新增新增附加费
     * @author hjr
     * @since 2020-08-08
     */
    ResultUtil<Integer> addSurcharge(List<SurchargePo> surchargePoList);


}
