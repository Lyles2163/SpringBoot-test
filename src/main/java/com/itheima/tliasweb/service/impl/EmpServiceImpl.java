package com.itheima.tliasweb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tliasweb.mapper.EmpMapper;
import com.itheima.tliasweb.pojo.Emp;
import com.itheima.tliasweb.pojo.PageResult;
import com.itheima.tliasweb.service.EmpService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param page
     * @param pageSize
     * 基于PageHelper后的分页查询方法
     * @return
     */
        @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
    //1.设置分页参数（PageHepler）
            PageHelper.startPage(page,pageSize);
    //2.执行查询
            List<Emp> empList = empMapper.list();
            Page<Emp> p = (Page<Emp>) empList;
    //3.解析查询结果，并封装为PageResult
            return new PageResult<Emp>(p.getTotal(),p.getResult());
    }
}
