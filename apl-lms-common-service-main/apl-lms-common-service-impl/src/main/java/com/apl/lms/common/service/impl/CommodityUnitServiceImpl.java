package com.apl.org.sys.service.impl;

import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.exception.AplException;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.DBUtils;
import com.apl.lib.utils.ResultUtils;
import com.apl.org.sys.dao.CommodityUnitDao;
import com.apl.org.sys.mapper.CommodityUnitMapper;
import com.apl.org.sys.pojo.dto.CommodityUnitKeyDto;
import com.apl.org.sys.pojo.po.CommodityUnitPo;
import com.apl.org.sys.pojo.vo.CommodityUnitVo;
import com.apl.org.sys.service.CommodityUnitService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.util.CollectionUtils;
import java.util.List;


/**
 * <p>
 * 商品单位 service实现类
 * </p>
 *
 * @author cy
 * @since 2019-12-19
 */
@Service
@Slf4j
public class CommodityUnitServiceImpl extends ServiceImpl<CommodityUnitMapper, CommodityUnitPo> implements CommodityUnitService {

    @Autowired
    CommodityUnitDao commodityUnitDao;


    @Override
    public ResultUtils<Long> add(CommodityUnitPo commodityUnit) {

        DBUtils.DBInfo dbInfo = commodityUnitDao.createDBinfo();

        this.exists(dbInfo, 0L, commodityUnit.getUnitCode(),  commodityUnit.getUnitName() );

        Long id =0l;
        try {
            // 开启事务
            dbInfo.dbUtils.beginTrans(dbInfo, TransactionDefinition.ISOLATION_READ_COMMITTED);
            id = commodityUnitDao.add(dbInfo, commodityUnit);

            // 提交事务
            dbInfo.dbUtils.commit(dbInfo);
        }
        catch (Exception e){
            // 回滚事务
            dbInfo.dbUtils.rollback(dbInfo);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , id);
    }


    @Override
    public ResultUtils<Boolean> updById(CommodityUnitPo commodityUnit) throws Exception {

        DBUtils.DBInfo dbInfo = commodityUnitDao.createDBinfo();

        this.exists(dbInfo, commodityUnit.getId(), commodityUnit.getUnitCode(),  commodityUnit.getUnitName() );

        Integer flag = commodityUnitDao.upd(dbInfo, commodityUnit);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL , false);
    }


    @Override
    public ResultUtils<Boolean> delById(Long id) throws Exception {

        DBUtils.DBInfo dbInfo = commodityUnitDao.createDBinfo();

        Integer flag = commodityUnitDao.del(dbInfo, id);
        if(flag.equals(1)){
            return ResultUtils.APPRESULT(CommonStatusCode.DEL_SUCCESS , true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.DEL_FAIL , false);
    }


    @Override
    public ResultUtils<CommodityUnitVo> selectById(Long id){

        DBUtils.DBInfo dbInfo = commodityUnitDao.createDBinfo();

        CommodityUnitVo commodityUnitInfoVo = commodityUnitDao.selectById(dbInfo, id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, commodityUnitInfoVo);
    }


    @Override
    public ResultUtils<Page<CommodityUnitVo>> getList(PageDto pageDto, CommodityUnitKeyDto keyDto) throws Exception {

        Page<CommodityUnitVo> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        DBUtils.DBInfo dbInfo = commodityUnitDao.createDBinfo();

        List<CommodityUnitVo>  list = commodityUnitDao.getList(dbInfo, pageDto, keyDto);

        page.setTotal(dbInfo.rsCount);

        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS , page);
    }


    void exists(DBUtils.DBInfo dbInfo, Long id,  String unitCode,   String unitName ) {

        List<CommodityUnitVo> list = commodityUnitDao.exists(dbInfo, id, unitCode,  unitName );
        if (!CollectionUtils.isEmpty(list)) {
           for(CommodityUnitVo  commodityUnitInfoVo : list) {

              if(commodityUnitInfoVo.getUnitCode().equals(unitCode))
                 throw new AplException("UNIT_CODE_EXIST", "unitCode已经存在");
              if(commodityUnitInfoVo.getUnitName().equals(unitName))
                 throw new AplException("UNIT_NAME_EXIST", "unitName已经存在");
           }
        }
    }
}
