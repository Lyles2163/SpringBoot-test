package com.itheima.tliasweb.service;

import com.itheima.tliasweb.pojo.Emp;
import com.itheima.tliasweb.pojo.EmpQueryParam;
import com.itheima.tliasweb.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    /*
    分页查询
     */
//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end );
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);
}
