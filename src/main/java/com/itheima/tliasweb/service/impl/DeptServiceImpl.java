package com.itheima.tliasweb.service.impl;

import com.itheima.tliasweb.mapper.DeptMapper;
import com.itheima.tliasweb.pojo.Dept;
import com.itheima.tliasweb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll(){
    return deptMapper.findAll();
    };
    @Override
    public void add(Dept dept){

        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
    @Override
    public void delete(Integer id){
        deptMapper.deleteById(id);
    }

    @Override
    public Dept getById(Integer id) {
        return  deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
