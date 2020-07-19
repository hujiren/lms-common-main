package com.apl.lms.common.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.apl.cache.AplCacheUtil;
import com.apl.db.datasource.DataSourceConfig;
import com.apl.db.datasource.DynamicDataSource;
import com.apl.db.utils.DBUtil;
import com.apl.lib.cachebase.BaseCacheUtil;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.security.SecurityUser;
import com.apl.lib.utils.CommonContextHolder;
import com.apl.lms.common.query.manage.dto.CommodityUnitDto;
import com.apl.lms.common.query.manage.dto.CommodityUnitKeyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommodityUnitDao {

    @Autowired
    DBUtil dbUtil;

    @Autowired
    AplCacheUtil aplCacheUtil;


    public DBUtil.DBInfo createDBinfo(){
        // 创建数据库连接信息
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();

        DruidDataSource druidDataSource = DynamicDataSource.getDruidDataSource(securityUser.getTenantGroup(),
                DataSourceConfig.sysProduct,
                "wms_stocks_history",
                aplCacheUtil);
        DBUtil.DBInfo dbInfo = dbUtil.connect(druidDataSource);
        dbInfo.setTenantValue(securityUser.getInnerOrgId());
        DBUtil.DBInfo.tenantIdName = "inner_org_id";

        dbInfo.dbUtil = dbUtil;

        return dbInfo;
    }

    // 添加
    public Long add(DBUtil.DBInfo dbInfo, CommodityUnitDto commodityUnit) throws Exception {

        return dbUtil.insertReturnId(dbInfo, commodityUnit, "commodity_unit");
    }


    // 修改
    public Integer upd(DBUtil.DBInfo dbInfo, CommodityUnitDto commodityUnit) throws Exception {

        return  dbUtil.updateById(dbInfo, commodityUnit, "commodity_unit");
    }


    // 删除
    public Integer del(DBUtil.DBInfo dbInfo, Long id) throws Exception {

        return dbUtil.delById(dbInfo, "commodity_unit", id);
    }


    // 查询单个
    public CommodityUnitDto selectById(DBUtil.DBInfo dbInfo, Long id){

        String sql = "select id,unit_code,unit_name FROM commodity_unit where id="+id.toString();
        CommodityUnitDto commodityUnitInfoVo = dbUtil.queryObj(dbInfo, sql, id, CommodityUnitDto.class);

        return commodityUnitInfoVo;
    }


    // 分页查询
    public List<CommodityUnitDto> getList(DBUtil.DBInfo dbInfo, PageDto pageDto, CommodityUnitKeyDto keyDto){

        String sql = " SELECT  id, unit_code, unit_name FROM commodity_unit";
        List<CommodityUnitDto>  list = dbUtil.queryPage(
                dbInfo,
                sql,
                keyDto,
                CommodityUnitDto.class,
                "id",
                pageDto.getPageIndex(),
                pageDto.getPageSize());

        return list;
    }


    // 检测是否存在
    public List<CommodityUnitDto> exists(DBUtil.DBInfo dbInfo, Long id, String unitCode, String unitName){

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("unitCode", unitCode);
        paramMap.put("unitName", unitName);

        StringBuffer sql = new StringBuffer();
        sql.append("select  id, unit_code, unit_name from commodity_unit");
        sql.append(" where (unit_code = :unitCode or unit_name = :unitName)");
        if(id!=null && id>0)
            sql.append(" and id<>"+id.toString());

        List<CommodityUnitDto>   list = dbUtil.queryList(
                dbInfo,
                sql.toString(),
                paramMap,
                CommodityUnitDto.class);

        return  list;
    }
}
