package com.apl.lms.common.dao;

import com.apl.lib.config.MyBatisPlusConfig;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.DBUtil;
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
    DBUtil DBUtil;

    // 创建数据库操作信息对象
    public DBUtil.DBInfo createDBinfo(){
        //DBUtil.DBInfo dbInfo = DBUtil.createDBinfo("basic");
        DBUtil.DBInfo dbInfo = DBUtil.createDBinfo();
        dbInfo.setTenantValue(MyBatisPlusConfig.tenantIdContextHolder.get());

        dbInfo.dbUtil = this.DBUtil;

        return  dbInfo;
    }

    // 添加
    public Long add(DBUtil.DBInfo dbInfo, CommodityUnitDto commodityUnit) throws Exception {

        return DBUtil.insert(dbInfo, commodityUnit, "commodity_unit", "id");
    }


    // 修改
    public Integer upd(DBUtil.DBInfo dbInfo, CommodityUnitDto commodityUnit) throws Exception {

        return  DBUtil.updateById(dbInfo, commodityUnit, "commodity_unit");
    }


    // 删除
    public Integer del(DBUtil.DBInfo dbInfo, Long id) throws Exception {

        return DBUtil.delById(dbInfo, "commodity_unit", id);
    }


    // 查询单个
    public CommodityUnitDto selectById(DBUtil.DBInfo dbInfo, Long id){

        String sql = "select id,unit_code,unit_name FROM commodity_unit where id="+id.toString();
        CommodityUnitDto commodityUnitInfoVo = DBUtil.queryObj(dbInfo, sql, id, CommodityUnitDto.class);

        return commodityUnitInfoVo;
    }


    // 分页查询
    public List<CommodityUnitDto> getList(DBUtil.DBInfo dbInfo, PageDto pageDto, CommodityUnitKeyDto keyDto){

        String sql = " SELECT  id, unit_code, unit_name FROM commodity_unit";
        List<CommodityUnitDto>  list = DBUtil.queryPage(
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

        List<CommodityUnitDto>   list = DBUtil.queryList(
                dbInfo,
                sql.toString(),
                paramMap,
                CommodityUnitDto.class);

        return  list;
    }
}
