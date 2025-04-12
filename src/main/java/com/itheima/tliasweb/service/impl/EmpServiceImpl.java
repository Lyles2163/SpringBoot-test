package com.itheima.tliasweb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tliasweb.mapper.EmpMapper;
import com.itheima.tliasweb.pojo.Emp;
import com.itheima.tliasweb.pojo.EmpQueryParam;
import com.itheima.tliasweb.pojo.PageResult;
import com.itheima.tliasweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     *
     * @param page
     * @param pageSize
     * 原始是分页查询的方法--------------------
     * @return
     */
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
////        1.调用mapper查询总记录数
//       Long total = empMapper.count();
////        2.调用mapper查询结果列表
//        Integer start = (page-1)*pageSize;
//        List<Emp> rows= empMapper.list(start,pageSize);
////        3.封装结果 pageResult
//
//        return new PageResult<Emp>(total,rows);
//    }

    /**
     *
     * 基于PageHelper后的分页查询方法
     * @return
     */
//    @Override
//        public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//    //1.设置分页参数（PageHepler）
//            PageHelper.startPage(page,pageSize);
//    //2.执行查询
//            List<Emp> empList = empMapper.list( name, gender,begin, end);
//            Page<Emp> p = (Page<Emp>) empList;
//    //3.解析查询结果，并封装为PageResult
//            return new PageResult<Emp>(p.getTotal(),p.getResult());
//    }
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1.设置分页参数（PageHepler）
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        //2.执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;
        //3.解析查询结果，并封装为PageResult
        return new PageResult<Emp>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Emp emp) {
        //1.保存员工的基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        //2.保存员工的工作经历信息
    }
}
