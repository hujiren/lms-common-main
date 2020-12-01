package com.apl.lms.common.service;


import com.apl.lms.common.query.manage.po.CommonFreightTypePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.utils.ResultUtil;

import java.util.List;

/**
 * <p>
 *     运输类型
 *  service接口
 * </p>
 *
 * @author hjr
 * @since 2020-09-29
 */
public interface FreightTypeService extends IService<CommonFreightTypePo> {

        /**
         * @Desc: 添加
         * @author hjr
         * @since 2020-09-29
         */
        ResultUtil<Long> add(CommonFreightTypePo commonFreightTypePo);


        /**
         * @Desc: 更新
         * @author hjr
         * @since 2020-09-29
         */
        ResultUtil<Boolean> updById(CommonFreightTypePo commonFreightTypePo);


        /**
         * @Desc: 删除
         * @author hjr
         * @since 2020-09-29
         */
        ResultUtil<Boolean> delById(Long id);


        /**
         * @Desc:获取列表
         * @author hjr
         * @since 2020-09-29
         */
        List<CommonFreightTypePo> getList();

}