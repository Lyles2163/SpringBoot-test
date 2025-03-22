package com.itheima.tliasweb.service;

import com.itheima.tliasweb.mapper.DeptMapper;
import com.itheima.tliasweb.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void add(Dept dept);

    void delete(Integer id);

    Dept getById(Integer deptId);

    void update(Dept dept);
}
