package com.apl.lms.common.service;


import com.apl.lms.common.query.manage.po.CommonFreightTypePo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.utils.ResultUtil;

import java.util.List;

/**
 * <p>
 *  service接口
 * </p>
 *
 * @author hjr
 * @since 2020-09-29
 */
public interface FreightTypeService extends IService<CommonFreightTypePo> {

        /**
         * @Desc: 添加一个CommonFreightTypePo实体
         * @author hjr
         * @since 2020-09-29
         */
        ResultUtil<Long> add(CommonFreightTypePo commonFreightTypePo);


        /**
         * @Desc: 根据id 更新一个CommonFreightTypePo 实体
         * @author hjr
         * @since 2020-09-29
         */
        ResultUtil<Boolean> updById(CommonFreightTypePo commonFreightTypePo);


        /**
         * @Desc: 根据id 查找一个CommonFreightTypePo 实体
         * @author hjr
         * @since 2020-09-29
         */
        ResultUtil<Boolean> delById(Long id);


        /**
         * @Desc: 分页查找 CommonFreightTypePo 列表
         * @author hjr
         * @since 2020-09-29
         */
        List<CommonFreightTypePo> getList();

}