package com.apl.lms.common.dao;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.CommonContextHolder;
import com.apl.lib.utils.DBUtils;
import com.apl.lms.common.dto.CommodityUnitKeyDto;
import com.apl.lms.common.po.CommodityUnitPo;
import com.apl.lms.common.vo.CommodityUnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommodityUnitDao {

    @Autowired
    DBUtils dbUtils;

    // 创建数据库操作信息对象
    public DBUtils.DBInfo createDBinfo(){
        //DBUtils.DBInfo dbInfo = dbUtils.createDBinfo("basic");
        DBUtils.DBInfo dbInfo = dbUtils.createDBinfo();
        dbInfo.setTenant("inner_org_id", CommonContextHolder.getSecurityUser().getInnerOrgId());

        dbInfo.dbUtils = this.dbUtils;

        return  dbInfo;
    }

    // 添加
    public Long add(DBUtils.DBInfo dbInfo, CommodityUnitPo commodityUnit) throws Exception {

        return dbUtils.insert(dbInfo, commodityUnit, "commodity_unit", "id");
    }


    // 修改
    public Integer upd(DBUtils.DBInfo dbInfo, CommodityUnitPo commodityUnit) throws Exception {

        return  dbUtils.updateById(dbInfo, commodityUnit, "commodity_unit");
    }


    // 删除
    public Integer del(DBUtils.DBInfo dbInfo, Long id) throws Exception {

        return dbUtils.delById(dbInfo, "commodity_unit", id);
    }


    // 查询单个
    public CommodityUnitVo selectById(DBUtils.DBInfo dbInfo, Long id){

        String sql = "select id,unit_code,unit_name FROM commodity_unit where id="+id.toString();
        CommodityUnitVo commodityUnitInfoVo = dbUtils.queryObj(dbInfo, sql, id, CommodityUnitVo.class);

        return commodityUnitInfoVo;
    }


    // 分页查询
    public List<CommodityUnitVo> getList(DBUtils.DBInfo dbInfo, PageDto pageDto, CommodityUnitKeyDto keyDto){

        String sql = " SELECT  id, unit_code, unit_name FROM commodity_unit";
        List<CommodityUnitVo>  list = dbUtils.queryPage(
                dbInfo,
                sql,
                keyDto,
                CommodityUnitVo.class,
                "id",
                pageDto.getPageIndex(),
                pageDto.getPageSize());

        return list;
    }


    // 检测是否存在
    public List<CommodityUnitVo> exists(DBUtils.DBInfo dbInfo, Long id, String unitCode, String unitName){

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("unitCode", unitCode);
        paramMap.put("unitName", unitName);

        StringBuffer sql = new StringBuffer();
        sql.append("select  id, unit_code, unit_name from commodity_unit");
        sql.append(" where (unit_code = :unitCode or unit_name = :unitName)");
        if(id!=null && id>0)
            sql.append(" and id<>"+id.toString());

        List<CommodityUnitVo>   list = dbUtils.queryList(
                dbInfo,
                sql.toString(),
                paramMap,
                CommodityUnitVo.class);

        return  list;
    }
}
