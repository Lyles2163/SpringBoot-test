package com.itheima.tliasweb.service;

import com.itheima.tliasweb.pojo.Emp;
import com.itheima.tliasweb.pojo.PageResult;

public interface EmpService {
    /*
    分页查询
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}
