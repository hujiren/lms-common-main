package com.apl.lms.common.service;
import com.apl.lib.utils.ResultUtil;

import com.apl.lms.common.query.manage.dto.SeaPortDto;
import com.apl.lms.common.query.manage.dto.SeaPortKeyDto;
import com.apl.lms.common.query.manage.vo.SeaPortListVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 海港 service接口
 * </p>
 *
 * @author hjr
 * @since 2020-04-13
 */
public interface SeaPortService extends IService<SeaPortDto> {

        /**
         * @Desc: 添加
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Integer> add(SeaPortDto seaPortDto);


        /**
         * @Desc: 更新
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> updById(SeaPortDto seaPortDto);


        /**
         * @Desc: 删除
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Boolean> delById(Long id);


        /**
         * @Desc: 获取详细
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<SeaPortDto> selectById(Long id);


        /**
         * @Desc: 分页查找列表
         * @author cy
         * @since 2020-04-13
         */
        ResultUtil<Page<SeaPortListVo>>getList(PageDto pageDto, SeaPortKeyDto seaPortKeyDto);

}
