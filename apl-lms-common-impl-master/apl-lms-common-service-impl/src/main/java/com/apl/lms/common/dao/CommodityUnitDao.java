package com.apl.lms.common.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.apl.cache.AplCacheUtil;
import com.apl.db.datasource.DataSourceConfig;
import com.apl.db.datasource.DynamicDataSource;
import com.apl.db.orm.AplDBInfo;
import com.apl.db.orm.AplDBPersistent;
import com.apl.db.orm.AplDBQuery;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.security.SecurityUser;
import com.apl.lib.utils.CommonContextHolder;
import com.apl.lms.common.query.manage.dto.CommodityUnitDto;
import com.apl.lms.common.query.manage.dto.CommodityUnitKeyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommodityUnitDao {

    @Autowired
    AplCacheUtil aplCacheUtil;


    public AplDBInfo connectDb(){
        // 创建数据库连接信息
        SecurityUser securityUser = CommonContextHolder.getSecurityUser();

        DruidDataSource druidDataSource = DynamicDataSource.getDruidDataSource(securityUser.getTenantGroup(),
                DataSourceConfig.sysProduct,
                "wms_stocks_history",
                aplCacheUtil);
        AplDBInfo dbInfo = new AplDBInfo(druidDataSource);
        dbInfo.setTenantValue(securityUser.getInnerOrgId());
        AplDBInfo.tenantIdName = "inner_org_id";

        return dbInfo;
    }

    // 添加
    public Long add(AplDBInfo dbInfo, CommodityUnitDto commodityUnit) throws Exception {

        return AplDBPersistent.insertReturnId(dbInfo, commodityUnit, "commodity_unit");
    }


    // 修改
    public Integer upd(AplDBInfo dbInfo, CommodityUnitDto commodityUnit) throws Exception {

        return  AplDBPersistent.updateById(dbInfo, commodityUnit, "commodity_unit");
    }


    // 删除
    public Integer del(AplDBInfo dbInfo, Long id) throws Exception {

        return AplDBPersistent.delById(dbInfo, "commodity_unit", id);
    }


    // 查询单个
    public CommodityUnitDto selectById(AplDBInfo dbInfo, Long id){

        String sql = "select id,unit_code,unit_name FROM commodity_unit where id="+id.toString();
        CommodityUnitDto commodityUnitInfoVo = AplDBQuery.queryObj(dbInfo, sql, id, CommodityUnitDto.class);

        return commodityUnitInfoVo;
    }


    // 分页查询
    public List<CommodityUnitDto> getList(AplDBInfo dbInfo, PageDto pageDto, CommodityUnitKeyDto keyDto){

        String sql = " SELECT  id, unit_code, unit_name FROM commodity_unit";
        List<CommodityUnitDto>  list = AplDBQuery.queryPage(
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
    public List<CommodityUnitDto> exists(AplDBInfo dbInfo, Long id, String unitCode, String unitName){

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("unitCode", unitCode);
        paramMap.put("unitName", unitName);

        StringBuffer sql = new StringBuffer();
        sql.append("select  id, unit_code, unit_name from commodity_unit");
        sql.append(" where (unit_code = :unitCode or unit_name = :unitName)");
        if(id!=null && id>0)
            sql.append(" and id<>"+id.toString());

        List<CommodityUnitDto>   list = AplDBQuery.queryList(
                dbInfo,
                sql.toString(),
                paramMap,
                CommodityUnitDto.class);

        return  list;
    }
}
