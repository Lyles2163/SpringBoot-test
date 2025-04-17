package com.itheima.tliasweb.mapper;

import com.itheima.tliasweb.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    //批量插入员工信息
    void insertBatch(List<EmpExpr> exprList);
}
