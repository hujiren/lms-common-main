package com.apl.lms.common.service;

import com.apl.lms.common.query.manage.po.CommonCarrierPo;
import com.baomidou.mybatisplus.extension.service.IService;
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
         * @Desc: 添加公共运输方
         * @author hjr
         * @since 2020-10-07
         */
        ResultUtil<Long> add(CommonCarrierPo commonCarrierPo) throws IOException;


        /**
         * @Desc: 更新公共运输方
         * @author hjr
         * @since 2020-10-07
         */
        ResultUtil<Boolean> updById(CommonCarrierPo commonCarrierPo) throws IOException;


        /**
         * @Desc: 删除
         * @author hjr
         * @since 2020-10-07
         */
        ResultUtil<Boolean> delById(Long id) throws IOException;


        /**
         * @Desc: 查找列表
         * @author hjr
         * @since 2020-10-07
         */
        List<CommonCarrierPo>getList() throws IOException;

}