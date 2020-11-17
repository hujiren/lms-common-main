package com.apl.lms.common.service;

import com.apl.lms.common.query.manage.po.CommonCarrierPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  service接口
 * </p>
 *
 * @author hjr
 * @since 2020-10-07
 */
public interface CommonCarrierService extends IService<CommonCarrierPo> {

        /**
         * @Desc: 添加一个CommonCarrierPo实体
         * @author hjr
         * @since 2020-10-07
         */
        ResultUtil<Long> add(CommonCarrierPo commonCarrierPo) throws IOException;


        /**
         * @Desc: 根据id 更新一个CommonCarrierPo 实体
         * @author hjr
         * @since 2020-10-07
         */
        ResultUtil<Boolean> updById(CommonCarrierPo commonCarrierPo) throws IOException;


        /**
         * @Desc: 根据id 查找一个CommonCarrierPo 实体
         * @author hjr
         * @since 2020-10-07
         */
        ResultUtil<Boolean> delById(Long id) throws IOException;


        /**
         * @Desc: 分页查找 CommonCarrierPo 列表
         * @author hjr
         * @since 2020-10-07
         */
        List<CommonCarrierPo>getList() throws IOException;

}